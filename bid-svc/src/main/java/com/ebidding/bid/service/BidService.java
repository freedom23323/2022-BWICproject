package com.ebidding.bid.service;

import com.ebidding.bid.domain.Bid;
import com.ebidding.bid.domain.BidRespondDto;
import com.ebidding.bid.domain.BidRankDto;
import com.ebidding.bid.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BidService {
    @Autowired
    private BidRepository bidRepository;

    public Optional<Bid> getBidByBwicAndClient(String bwic, String client) {
        return this.bidRepository.findByBwicidAndClientid(bwic, client);
    }

    public Optional<Bid> getBidById(String id) {
        return this.bidRepository.findById(id);
    }

    public Optional<List<Bid>> getBidByBwic(String bwic) {
        return this.bidRepository.findByBwicid(bwic);
    }

    public Optional<List<Bid>> getBidByClient(String client) {
        return this.bidRepository.findByClientid(client);
    }

    public BidRankDto getRank(String bwic, String client) {
        Optional<List<Bid>> bidOp = getBidByBwic(bwic);
        Bid[] bid;
        BidRankDto bidRD = new BidRankDto();
        if (bidOp.isPresent()) {
            bid = bidOp.get().toArray(new Bid[0]);
            Arrays.sort(bid, (b1, b2) -> b2.getPrice().compareTo(b1.getPrice()));
            int total = bid.length;
            int current = 1;
            for (Bid b : bid) {
                if (b.getClientid().equals(client)) break;
                current++;
            }
            bidRD.setSuccess(1);
            if (current > total) bidRD.setCurrentRank(null);
            else bidRD.setCurrentRank(current);
            bidRD.setTotalRank(total);
            if (current == 1 && total > 1) bidRD.setSecondPrice(bid[1].getPrice());
            else bidRD.setSecondPrice(null);
        } else {
            bidRD.setSuccess(-1);
            bidRD.setCurrentRank(null);
            bidRD.setTotalRank(null);
            bidRD.setSecondPrice(null);
        }
        return bidRD;
    }

    public BidRespondDto createBid(String bwic, String client, Double price) {
        if (getBidByBwicAndClient(bwic, client).isEmpty()) {
            // 不允许重复创建
            Bid bid = new Bid();
            bid.setBwicid(bwic);
            bid.setClientid(client);
            bid.setPrice(price);
            bid.setBiddate(new Date(System.currentTimeMillis()));
            bid = this.bidRepository.save(bid);
            BidRespondDto bidRespond = new BidRespondDto();
            bidRespond.setSuccess(1);
            bidRespond.setBid(bid);
            return bidRespond;
        } else {
            // 重复创建返回 -1
            BidRespondDto bidRespond = new BidRespondDto();
            bidRespond.setSuccess(-1);
            bidRespond.setBid(null);
            return bidRespond;
        }
    }

    public BidRespondDto updateBid(String bwic, String client, Double price) {
        Optional<Bid> bidOP = getBidByBwicAndClient(bwic, client);
        return updateBidFunc(price, bidOP);
    }

    public BidRespondDto updateBid(String id, Double price) {
        Optional<Bid> bidOP = getBidById(id);
        return updateBidFunc(price, bidOP);
    }

    private BidRespondDto updateBidFunc(Double price, Optional<Bid> bidOP) {
        BidRespondDto bidRespond = new BidRespondDto();
        if (bidOP.isPresent()) {
            Bid bid=bidOP.get();
            bid.setPrice(price);
            bid.setBiddate(new Date(System.currentTimeMillis()));
            this.bidRepository.save(bid);
            bidRespond.setSuccess(1);
            bidRespond.setBid(bid);
        }else{
            bidRespond.setSuccess(-1);
            bidRespond.setBid(null);
        }
        return bidRespond;
    }

    public BidRespondDto deleteBid(String bwic, String client) {
        Optional<Bid> bid = getBidByBwicAndClient(bwic, client);
        return deleteBidFunc(bid);
    }

    public BidRespondDto deleteBid(String id) {
        Optional<Bid> bid = getBidById(id);
        return deleteBidFunc(bid);
    }

    private BidRespondDto deleteBidFunc(Optional<Bid> bid) {
        BidRespondDto bidRespond = new BidRespondDto();
        if (bid.isPresent()) {
            this.bidRepository.deleteById(bid.get().getId());
            bidRespond.setSuccess(1);
            bidRespond.setBid(bid.get());
        } else {
            bidRespond.setSuccess(-1);
            bidRespond.setBid(null);
        }
        return bidRespond;
    }
}
