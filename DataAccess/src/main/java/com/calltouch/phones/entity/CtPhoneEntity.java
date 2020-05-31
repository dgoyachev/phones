package com.calltouch.phones.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by morgan on 31.05.2020
 */

@Entity
public class CtPhoneEntity {
    @Id
    private int id;

    private long number;

    private String description;

    public CtPhoneEntity(int id, long number, String description) {
        this.id = id;
        this.number = number;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
