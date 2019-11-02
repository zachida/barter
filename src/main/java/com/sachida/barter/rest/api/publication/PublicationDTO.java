package com.sachida.barter.rest.api.publication;

import com.sachida.barter.datasource.model.Status;

import java.math.BigDecimal;

public class PublicationDTO {

    private Long id;
    private Long userId;
    //private Map<String, Long> products;
    private BigDecimal price;
    private Boolean visible;
    private String location;
    private String status;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}