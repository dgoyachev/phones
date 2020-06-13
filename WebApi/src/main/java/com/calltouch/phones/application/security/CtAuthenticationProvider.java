package com.calltouch.phones.application.security;

import com.calltouch.phones.domain.PartyAccessTokenData;
import com.calltouch.phones.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Created by morgan on 07.06.2020
 */

@Component
public class CtAuthenticationProvider implements AuthenticationProvider {

    private final Logger logger = LoggerFactory.getLogger(CtAuthenticationProvider.class);
    private final AuthenticationService authenticationService;

    public CtAuthenticationProvider(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("authenticate: " + authentication);

        String token = (String) authentication.getPrincipal();

        PartyAccessTokenData partyAccessTokenData = authenticationService.authenticatePartyByToken(token);
        if(partyAccessTokenData == null) {
            throw new UsernameNotFoundException("Cannot find user with authentication token=" + token);
        }
        SecurityUserDetails securityUserDetails = new SecurityUserDetails(partyAccessTokenData);
        return new CtAuthenticationToken(securityUserDetails, securityUserDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(PreAuthenticatedAuthenticationToken.class);
    }
}
