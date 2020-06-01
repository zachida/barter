package com.sachida.barter.datasource.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="bid")
public class Bid  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sellerId;
    private Long sellerPublicationId;
    private Long buyerId;
    private Long buyerPublicationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getSellerPublicationId() {
        return sellerPublicationId;
    }

    public void setSellerPublicationId(Long sellerPublicationId) {
        this.sellerPublicationId = sellerPublicationId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getBuyerPublicationId() {
        return buyerPublicationId;
    }

    public void setBuyerPublicationId(Long buyerPublicationId) {
        this.buyerPublicationId = buyerPublicationId;
    }
}
