package com.movie.back.dto;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class MemberDTO extends User {

    private String email;

    private String password;

    private String birth;

    private String gender;

    private String nickName;
    public MemberDTO(String username, String password, String nickName,Collection<GrantedAuthority> authorities){
        super(username,password,authorities);
        this.email = username;

        this.password = password;
        this.nickName = nickName;
    }
}
