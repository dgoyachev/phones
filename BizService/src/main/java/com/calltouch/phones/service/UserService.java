package com.calltouch.phones.service;

import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserService {

    String login(String username, String password);

    Optional<User> findByToken(String token);
}