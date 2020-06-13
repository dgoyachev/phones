package com.calltouch.phones.domain.enums;

public enum PartyStatus {

    ACTIVE(1L, "Активный"),
    INACTIVE(2L, "Не активный"),
    BLOCKED(3L,"Заблокирован"),
    REGISTRATION_PENDING(4L,"Ожидает регистрации"),
    DELETED(5L, "Удалён");

    private final long id;
    private final String displayName;

    PartyStatus(long id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return name();
    }

    public static PartyStatus valueOf(long id) {
        for (PartyStatus v : values()) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public String getDisplayName() {
        return displayName;
    }
}