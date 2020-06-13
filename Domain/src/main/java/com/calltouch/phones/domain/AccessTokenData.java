package com.calltouch.phones.domain;

import com.calltouch.phones.domain.enums.AccessTokenStatus;
import com.calltouch.phones.domain.enums.AccessType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by morgan on 13.06.2020
 */

public class AccessTokenData implements Serializable {

    private final long accessTokenId;
    private final long partyId;
    private final String token;
    private final String addBy;
    private final LocalDateTime effDate;
    private final LocalDateTime expDate;
    private final AccessTokenStatus status;
    private final AccessType accessType;

    public AccessTokenData(long accessTokenId, long partyId, String token, String addBy, LocalDateTime effDate, LocalDateTime expDate, AccessTokenStatus status, AccessType accessType) {
        this.accessTokenId = accessTokenId;
        this.partyId = partyId;
        this.token = token;
        this.addBy = addBy;
        this.effDate = effDate;
        this.expDate = expDate;
        this.status = status;
        this.accessType = accessType;
    }

    public long getAccessTokenId() {
        return accessTokenId;
    }

    public long getPartyId() {
        return partyId;
    }

    public String getToken() {
        return token;
    }

    public String getAddBy() {
        return addBy;
    }

    public LocalDateTime getEffDate() {
        return effDate;
    }

    public LocalDateTime getExpDate() {
        return expDate;
    }

    public AccessTokenStatus getStatus() {
        return status;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    @Override
    public String toString() {
        return "AccessTokenData{" +
                "accessTokenId=" + accessTokenId +
                ", partyId=" + partyId +
                ", token='" + token + '\'' +
                ", addBy='" + addBy + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", status=" + status +
                ", accessType=" + accessType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessTokenData that = (AccessTokenData) o;

        return accessTokenId == that.accessTokenId;
    }

    @Override
    public int hashCode() {
        return (int) (accessTokenId ^ (accessTokenId >>> 32));
    }
}
