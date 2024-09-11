package com.f2d.group_builder.service;

import com.f2d.group_builder.domain.F2DUser;
import com.f2d.group_builder.domain.UserSearchResponse;
import com.f2d.group_builder.feign.F2DUserAuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class F2DUserDetailsService implements UserDetailsService {

    @Autowired
    private F2DUserAuthClient f2dUserAuthClient;

    @Override
    public UserDetails loadUserByUsername(String usernameRequest) throws UsernameNotFoundException {
        ResponseEntity<UserSearchResponse> user = f2dUserAuthClient.getUserInfoByUsername(usernameRequest);
        String username = Objects.requireNonNull(user.getBody()).getUser().getUsername();
        String password = user.getBody().getUser().getPassword();
        return new org.springframework.security.core.userdetails.User(username,password, new ArrayList<>());
    }
}
