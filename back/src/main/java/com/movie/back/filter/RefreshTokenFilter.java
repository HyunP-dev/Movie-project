package com.movie.back.filter;

import com.google.gson.Gson;
import com.movie.back.security.exception.RefreshTokenException;
import com.movie.back.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;


@Slf4j
@RequiredArgsConstructor
public class RefreshTokenFilter extends OncePerRequestFilter {
    private final String refreshPath;

    private final JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String path = request.getRequestURI();

        if(!path.equals(refreshPath)){
            log.info("Skip refresh token filter......");
            filterChain.doFilter(request,response);
            return;
        }

        log.info("Refresh Token Filter ......run.............1");

        //전송된 JSON에서 accessToken과 refreshToken을 얻어온다.
        Map<String,String> tokens = parseRequestJSON(request);

        String accessToken = tokens.get("accessToken");
        String refreshToken = tokens.get("refreshToken");

        log.info("accessTopken: "+accessToken);
        log.info("refreshToken: "+refreshToken);

        try{
            checkAccessToken(accessToken);
        }catch (RefreshTokenException refreshTokenException){
            refreshTokenException.sendResponseError(response);
            return;
        }
    }

    private void checkAccessToken(String accessToken) throws RefreshTokenException{
        try{
            jwtUtil.validateToken(accessToken);

        }catch (ExpiredJwtException exception){
            log.info("Access Token has expired");
        }catch (Exception e){
            throw new RefreshTokenException(RefreshTokenException.ErrorCase.NO_ACCESS);
        }
    }

    //Refresh Token의 경우도 검사가 필요하다. RefreshToken이 존재하는지와
    //만료일이 지났는지를 확인하고 새로운 토큰 생성을 위해서 mid 값을얻어두도록 한다.
    //RefreshTokenFilter 내부에 checkRefreshToken()을 생성해서 문재가 생기면 RefreshTokenException을 발생
    //정상이라면 토늨 내용물들을 Map으로 반환하도록 구성한다.
    private Map<String,Object> checkRefreshToken(String refreshToken) throws RefreshTokenException{
        try{
            Map<String,Object> values = jwtUtil.validateToken(refreshToken);
            return values;
        }catch (ExpiredJwtException e){
            throw new RefreshTokenException(RefreshTokenException.ErrorCase.OLD_REFRESH);
        }
        //이어서 적어야한다
    }


    private Map<String,String> parseRequestJSON(HttpServletRequest request){
        //JSON 데이터를 분석해서 mid, mpw 전달 값을 Map으로 처리
        try(Reader reader = new InputStreamReader(request.getInputStream())){
            Gson gson = new Gson();
            return gson.fromJson(reader,Map.class); //request로 들어온 json데이터를 Map으로 바꾼다.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
