package com.calltouch.phones.service;

import com.calltouch.phones.domain.PartyAccessTokenData;

public interface AuthenticationService {

    PartyAccessTokenData authenticatePartyByToken(String accessToken);

    PartyAccessTokenData authenticatePartyByNameAndPassword(String userName, String encodingPassword, Long tokenExpirationTime);

    PartyAccessTokenData prolongRegularAccess(Long partyId, String token, Long tokenExpirationTime);
}
