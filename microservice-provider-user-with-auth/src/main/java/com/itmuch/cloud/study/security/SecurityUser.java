package com.itmuch.cloud.study.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 自定义UserDetails
 * User: monkey
 * Date: 2018-11-12 16:13
 */
public class SecurityUser  implements UserDetails {

    public SecurityUser() {
    }

    public SecurityUser(String username, String password, String role) {

        super();
        this.id=3L;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    private Long id;
    private String username;
    private String password;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role);
        authorities.add(authority);
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
