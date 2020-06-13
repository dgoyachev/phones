package com.calltouch.phones.domain;

/**
 * Created by morgan on 13.06.2020
 */

public class PartyAccessTokenData {

    private final PartyData partyData;
    private final AccessTokenData accessTokenData;

    public PartyAccessTokenData(PartyData partyData, AccessTokenData accessTokenData) {
        this.partyData = partyData;
        this.accessTokenData = accessTokenData;
    }

    public AccessTokenData getAccessTokenData() {
        return accessTokenData;
    }

    public PartyData getPartyData() {
        return partyData;
    }

    @Override
    public String toString() {
        return "PartyAccessTokenData{" +
                "accessTokenData=" + accessTokenData +
                ", partyData=" + partyData +
                '}';
    }
}
