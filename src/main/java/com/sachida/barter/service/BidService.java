package com.sachida.barter.service;

import com.sachida.barter.datasource.model.Bid;
import com.sachida.barter.datasource.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {

    private BidRepository bidRepository;

    public Bid bid(Bid bid)
    {
        return bidRepository.save(bid);
    }

    @Autowired
    public void setBidRepository(BidRepository bidRepository){
        this.bidRepository = bidRepository;
    }
}
