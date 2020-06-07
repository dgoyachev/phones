package com.calltouch.phones.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by morgan on 07.06.2020
 */

@Service
public class UserServiceImpl implements UserService {

    private final String systemToken = "RuWcwSnwGqjjsB6YdiSwwtVGVKrXHuLfjddejs0H";

    @Override
    public String login(String username, String password) {
        return systemToken;
    }

    @Override
    public Optional<User> findByToken(String token) {
        if(systemToken.equals(token)) {
            return Optional.of(
                    new User(
                            "Test Admin",
                            "Test Password",
                            true,
                            true,
                            true,
                            true,
                            AuthorityUtils.createAuthorityList("USER")
                    )
            );
        }
        else {
            return Optional.empty();
        }
    }
}
