package com.calltouch.phones.domain;

/**
 * Created by morgan on 31.05.2020
 */

public class PhoneData {

    private Integer id;
    private Long number;
    private String description;

    public PhoneData(Integer id, Long number, String description) {
        this.id = id;
        this.number = number;
        this.description = description;
    }

    public PhoneData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PhoneData{" +
                "id=" + id +
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }
}
