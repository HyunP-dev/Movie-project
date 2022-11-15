package com.movie.back.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MemberDTO extends User {

    private String email;

    private String password;

    public MemberDTO(String username, String password, Collection<GrantedAuthority> authorities){
        super(username,password,authorities);
        this.email = username;
        this.password = password;
    }
}
