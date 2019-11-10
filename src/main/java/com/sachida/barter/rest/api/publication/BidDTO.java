package com.sachida.barter.rest.api.publication;

public class BidDTO {

    private String Id;
    private String sellerId;
    private String sellerPublicationId;
    private String buyerId;
    private String buyerPublicationId;


    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerPublicationId() {
        return sellerPublicationId;
    }

    public void setSellerPublicationId(String sellerPublicationId) {
        this.sellerPublicationId = sellerPublicationId;
    }

    public String getId() {
        return Id;
    }

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

    public void setId(String id) {
        Id = id;
    }
}
