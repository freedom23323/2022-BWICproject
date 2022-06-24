package com.ebidding.bid.service;

import com.ebidding.bid.domain.Bid;
import com.ebidding.bid.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BidService {
    @Autowired
    private BidRepository bidRepository;

    public Optional<Bid> getBidByBwicAndClient(String bwic,String client) {
        return this.bidRepository.findByBwicidAndClientid(bwic,client);
    }

    public Optional<Bid>  getBidById(String id) {
        return this.bidRepository.findById(id);
    }
    public Optional<List<Bid>> getBidByBwic(String bwic) {
        return this.bidRepository.findByBwicid(bwic);
    }

    public Optional<List<Bid>> getBidByClient(String client) {
        return this.bidRepository.findByClientid(client);
    }


    public Optional<Bid> createBid(String bwic, String client, Double price) {
        if(getBidByBwicAndClient(bwic, client).isEmpty()) {
            Bid bid = new Bid();
            bid.setBwicid(bwic);
            bid.setClientid(client);
            bid.setPrice(price);
            bid.setBiddate(new Date(System.currentTimeMillis()));
            return Optional.of(this.bidRepository.save(bid));
        }else return Optional.empty();
    }
}
