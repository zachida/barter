package com.sachida.barter.rest.api.publication;

import java.math.BigDecimal;
import java.util.Map;

public class PublicationModificationDTO {

    private Map<String, Long> products;
    private BigDecimal price;
    private Boolean visible;
    private String location;

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

}
