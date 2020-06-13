package com.calltouch.phones.application.security;

import com.calltouch.phones.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by morgan on 07.06.2020
 */

public class CtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String ACCESS_TOKEN = "access_token";

    private final AuthenticationService authenticationService;

    private final Logger logger = LoggerFactory.getLogger(CtAuthenticationFilter.class);

    public CtAuthenticationFilter(final RequestMatcher requiresAuth, final AuthenticationService authenticationService) {
        super(requiresAuth);
        this.authenticationService = authenticationService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {
        String token = httpServletRequest.getParameter(ACCESS_TOKEN);
        logger.info("attemptAuthentication with token " + token);
        PreAuthenticatedAuthenticationToken authenticationToken = new PreAuthenticatedAuthenticationToken(token, null);
        return getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain, final Authentication authResult) throws IOException, ServletException {
        logger.info("successfulAuthentication");
        SecurityContextHolder.getContext().setAuthentication(authResult);

        SecurityUserDetails userDetails = (SecurityUserDetails) authResult.getPrincipal();
        authenticationService.prolongRegularAccess(userDetails.getPartyData().getPartyId(), userDetails.getAccessTokenData().getToken(), 120*60*1000L);
        chain.doFilter(request, response);
    }
}