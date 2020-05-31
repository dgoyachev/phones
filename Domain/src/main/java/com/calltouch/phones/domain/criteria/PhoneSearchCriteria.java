package com.calltouch.phones.domain.criteria;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by morgan on 31.05.2020
 */

public class PhoneSearchCriteria implements Serializable {

    @ApiModelProperty(value = "ид телефона", example = "1", allowEmptyValue = true)
    private Integer id;
    @ApiModelProperty(value = "номер телефона", example = "4951234567", allowEmptyValue = true)
    private Long number;
    @ApiModelProperty(value = "описание телефона", example = "резервный", allowEmptyValue = true)
    private String description;

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
        return "PhoneSearchCriteria{" +
                "id=" + id +
                ", number=" + number +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
