package com.calltouch.phones.domain;

import com.calltouch.phones.domain.enums.PartyStatus;
import com.calltouch.phones.domain.enums.PartyType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by morgan on 13.06.2020
 */

public class PartyData implements Serializable {

    private final long partyId;
    private final String partyName;
    private final String partyLongName;
    private final PartyType partyType;
    private final PartyStatus partyStatus;
    private final LocalDateTime effDate;
    private final LocalDateTime expDate;
    private final String email;

    public PartyData(long partyId, String partyName, String partyLongName, PartyType partyType, PartyStatus partyStatus, LocalDateTime effDate, LocalDateTime expDate, String email) {
        this.partyId = partyId;
        this.partyName = partyName;
        this.partyLongName = partyLongName;
        this.partyType = partyType;
        this.partyStatus = partyStatus;
        this.effDate = effDate;
        this.expDate = expDate;
        this.email = email;
    }

    public long getPartyId() {
        return partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public String getPartyLongName() {
        return partyLongName;
    }

    public PartyType getPartyType() {
        return partyType;
    }

    public PartyStatus getPartyStatus() {
        return partyStatus;
    }

    public LocalDateTime getEffDate() {
        return effDate;
    }

    public LocalDateTime getExpDate() {
        return expDate;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "PartyData{" +
                "partyId=" + partyId +
                ", partyName='" + partyName + '\'' +
                ", partyLongName='" + partyLongName + '\'' +
                ", partyType=" + partyType +
                ", partyStatus=" + partyStatus +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartyData partyData = (PartyData) o;

        return partyId == partyData.partyId;
    }

    @Override
    public int hashCode() {
        return (int) (partyId ^ (partyId >>> 32));
    }
}
