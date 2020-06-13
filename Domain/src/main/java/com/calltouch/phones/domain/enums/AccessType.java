package com.calltouch.phones.domain.enums;

public enum AccessType {

    REST_API_ACCESS(1),
    REST_API_ACCESS_ADMIN(2),
    REST_API_ACCESS_MANAGER(3),
    REST_API_ACCESS_TECH_SUPPORT(4),
    LK_REMOTE_LOGIN(5),
    OAUTH_AUTHORIZATION_TOKEN(6),
    REMEMBER_ME_TOKEN(7),
    REST_API_ACCESS_INTEGRATION_SERVICE(8),
    REST_API_ACCESS_REGISTRATION(9),
    REST_API_ACCESS_CONFIG_MANAGER(10),
    REST_API_ACCESS_BILL_REMINDER(11),
    REST_API_ACCESS_CRM(12),
    WEB_API_ACCESS(13),
    REST_API_ACCESS_PARTY_LK(14),
    NEW_LK_PARTY_REGISTRATION(15),
    REST_API_ACCESS_TELEMIR(16),
    NEW_LK_SESSION_ID(17);

    public static final String REST_API_ACCESS_PREFIX_ROLE = "REST_API_ACCESS_";

    private final long id;

    AccessType(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return name();
    }

    public static AccessType valueOf(Long id) {
        for (AccessType v : values()) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public static AccessType valueOf(PartyType partyType) {
        for (AccessType v : values()) {
            if (v.getCode().equals(REST_API_ACCESS_PREFIX_ROLE +partyType.getCode())) {
                return v;
            }
        }
        return null;
    }

    public static boolean isRegularAccess(AccessType accessType) {
        return (
                accessType == REST_API_ACCESS_ADMIN
                        || accessType == REST_API_ACCESS_MANAGER
                        || accessType == REST_API_ACCESS_TECH_SUPPORT
        );
    }
}
