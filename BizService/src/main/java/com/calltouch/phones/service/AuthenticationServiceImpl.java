package com.calltouch.phones.service;

import com.calltouch.phones.domain.AccessTokenData;
import com.calltouch.phones.domain.PartyAccessTokenData;
import com.calltouch.phones.domain.PartyData;
import com.calltouch.phones.domain.enums.AccessTokenStatus;
import com.calltouch.phones.domain.enums.AccessType;
import com.calltouch.phones.domain.enums.PartyStatus;
import com.calltouch.phones.domain.enums.PartyType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by morgan on 13.06.2020
 */

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final String systemToken = "RuWcwSnwGqjjsB6YdiSwwtVGVKrXHuLfjddejs0H";

    @Override
    public PartyAccessTokenData authenticatePartyByToken(String accessToken) {
        if(!systemToken.equals(accessToken)) {
            return null;
        }

        AccessTokenData accessTokenData = new AccessTokenData(
                1,
                1,
                systemToken,
                "CtPartyDAO",
                LocalDateTime.now().minusDays(100),
                LocalDateTime.now().plusDays(100),
                AccessTokenStatus.ALIVE,
                AccessType.REST_API_ACCESS_ADMIN
        );

        PartyData partyData = new PartyData(
                1,
                "admin",
                "Admin",
                PartyType.ADMIN,
                PartyStatus.ACTIVE,
                LocalDateTime.now().minusDays(100),
                LocalDateTime.now().plusDays(100),
                "admin@calltouch.net"
        );

        return new PartyAccessTokenData(partyData, accessTokenData);
    }

    @Override
    public PartyAccessTokenData authenticatePartyByNameAndPassword(String userName, String encodingPassword, Long tokenExpirationTime) {
        return null;
    }

    @Override
    public PartyAccessTokenData prolongRegularAccess(Long partyId, String token, Long tokenExpirationTime) {
        return null;
    }
}
