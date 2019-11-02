package com.sachida.barter.rest.api.publication;

import java.math.BigDecimal;

public class PublicationRequestDTO {

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