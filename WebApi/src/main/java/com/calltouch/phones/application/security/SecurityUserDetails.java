package com.calltouch.phones.application.security;

import com.calltouch.phones.domain.AccessTokenData;
import com.calltouch.phones.domain.PartyAccessTokenData;
import com.calltouch.phones.domain.PartyData;
import com.calltouch.phones.domain.enums.AccessTokenStatus;
import com.calltouch.phones.domain.enums.PartyStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by morgan on 12.06.2020
 */

public class SecurityUserDetails implements UserDetails {

    private static final String ANONYMOUS = "ANONYMOUS";
    private static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";
    private static final String ROLE_PREFIX = "ROLE_";

    private final PartyData partyData;
    private final AccessTokenData accessTokenData;

    private final String password = null;
    private final String username;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
    private final Collection<SimpleGrantedAuthority> authorities = new LinkedList<SimpleGrantedAuthority>();

    public SecurityUserDetails(PartyAccessTokenData partyAccessTokenData) {
        if(partyAccessTokenData == null || partyAccessTokenData.getPartyData() == null || partyAccessTokenData.getAccessTokenData() == null) {
            this.partyData = null;
            this.accessTokenData = null;
            this.username = ANONYMOUS;
            this.enabled = false;
            this.accountNonLocked = false;
            this.accountNonExpired = false;
            this.credentialsNonExpired = false;
            this.authorities.add(new SimpleGrantedAuthority(ROLE_ANONYMOUS));
        }
        else {
            this.partyData = partyAccessTokenData.getPartyData();
            this.accessTokenData = partyAccessTokenData.getAccessTokenData();

            this.username = partyAccessTokenData.getPartyData().getPartyName();

            this.enabled = this.partyData.getPartyStatus() == PartyStatus.ACTIVE;
            this.accountNonLocked = this.partyData.getPartyStatus() == PartyStatus.ACTIVE;
            this.accountNonExpired = this.partyData.getExpDate().isAfter(LocalDateTime.now()) && this.partyData.getEffDate().isBefore(LocalDateTime.now());
            this.credentialsNonExpired = this.accessTokenData.getStatus() == AccessTokenStatus.ALIVE && this.accessTokenData.getExpDate().isAfter(LocalDateTime.now()) && this.accessTokenData.getEffDate().isBefore(LocalDateTime.now());

            this.authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + this.accessTokenData.getAccessType().getCode().toUpperCase()));
        }
    }

    public PartyData getPartyData() {
        return partyData;
    }

    public AccessTokenData getAccessTokenData() {
        return accessTokenData;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
