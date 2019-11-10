package com.sachida.barter.rest.api.publication;

public class BidRequestDTO {

    private String buyerId;
    private String buyerPublicationId;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerPublicationId() {
        return buyerPublicationId;
    }

    public void setBuyerPublicationId(String buyerPublicationId) {
        this.buyerPublicationId = buyerPublicationId;
    }
}
