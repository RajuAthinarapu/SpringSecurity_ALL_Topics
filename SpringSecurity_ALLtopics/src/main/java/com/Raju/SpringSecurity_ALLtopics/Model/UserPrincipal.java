package com.Raju.SpringSecurity_ALLtopics.Model;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrincipal implements UserDetails {

 private  Users user; //

    public UserPrincipal(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // this method is used to return the authorities of the user and we are returning a single authority "USER" for all the users
        return  Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public @Nullable String getPassword() { // this method is used to return the password of the user and we are returning the password of the user from the user object
        return user.getPassword();
    }

    @Override
    public String getUsername() { //
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {//
        return true; //make true cause boolean
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //make true cause boolean
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //make true cause boolean
    }

    @Override
    public boolean isEnabled() {
        return true; //make true cause boolean
    }
}
