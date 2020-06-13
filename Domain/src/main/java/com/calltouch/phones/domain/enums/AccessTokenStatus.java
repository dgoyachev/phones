package com.calltouch.phones.domain.enums;

public enum AccessTokenStatus {

    ALIVE(1L),
    INVALID(2L);

    private final long id;

    AccessTokenStatus(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return name();
    }

    public static AccessTokenStatus valueOf(long id) {
        for (AccessTokenStatus v : values()) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
}
