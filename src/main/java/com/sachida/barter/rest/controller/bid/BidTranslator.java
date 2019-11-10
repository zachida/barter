package com.sachida.barter.rest.controller.bid;

import com.sachida.barter.datasource.model.Bid;
import com.sachida.barter.rest.api.publication.BidDTO;
import com.sachida.barter.rest.api.publication.BidRequestDTO;

public class BidTranslator {
    public static Bid translateToEntity(BidRequestDTO bidRequest, String sellerId, String publicationId)
    {
        Bid bid = new Bid();
        bid.setBuyerId(Long.valueOf(bidRequest.getBuyerId()));
        bid.setBuyerPublicationId(Long.valueOf(bidRequest.getBuyerPublicationId()));
        bid.setSellerId(Long.valueOf(sellerId));
        bid.setSellerPublicationId(Long.valueOf(publicationId));
        return bid;
    }

    public static BidDTO translateToDTO(Bid bid){
        BidDTO biddto = new BidDTO();
        bid.setBuyerId(bid.getBuyerId());
        bid.setBuyerPublicationId(bid.getBuyerPublicationId());
        bid.setSellerId(bid.getSellerId());
        bid.setSellerPublicationId(bid.getSellerPublicationId());
        return biddto;
    }
}
