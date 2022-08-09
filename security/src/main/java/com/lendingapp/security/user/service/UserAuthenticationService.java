package com.lendingapp.security.user.service;

import com.lendingapp.security.user.model.User;
import com.lendingapp.security.user.model.UserDetailsImpl;

import java.util.Optional;

public interface UserAuthenticationService {

    Optional<String> login (String username, String password);
    User findByToken(String token);
}
