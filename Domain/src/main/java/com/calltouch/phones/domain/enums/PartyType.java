package com.calltouch.phones.domain.enums;

public enum PartyType {

    PARTNER(1L),
    ADMIN(2L),
    ORGANIZATION(3L),
    AGENT(4L),
    MANAGER(5L),
    TECH_SUPPORT(6L),
    LK_USER(7L),
    APPLICATION(8L),
    INTEGRATION_SERVICE(9L);

    private final long id;

    PartyType(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return name();
    }

    public static PartyType valueOf(long id) {
        for (PartyType v : values()) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
}
