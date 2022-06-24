package com.ebidding.bid.controller;

import com.ebidding.bid.domain.Bid;
import com.ebidding.bid.domain.BidRespondDto;
import com.ebidding.bid.domain.BidRankDto;
import com.ebidding.bid.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/bid")
public class BidController {
    @Autowired
    private BidService bidService;

    @GetMapping("findById")
    public ResponseEntity<Optional<Bid>> getBitById(@RequestParam String id) {
        return ResponseEntity.ok(this.bidService.getBidById(id));
    }

    @GetMapping("findByClient")
    public ResponseEntity<Optional<List<Bid>>> getBitByClient(@RequestParam String client) {
        return ResponseEntity.ok(this.bidService.getBidByClient(client));
    }

    @GetMapping("findByBwic")
    public ResponseEntity<Optional<List<Bid>>> getBitByBwic(@RequestParam String bwic) {
        return ResponseEntity.ok(this.bidService.getBidByBwic(bwic));
    }

    @GetMapping("findByBwicAndClient")
    public ResponseEntity<Optional<Bid>> getBitByBwicAndClient(@RequestParam String bwic, @RequestParam String client) {
        return ResponseEntity.ok(this.bidService.getBidByBwicAndClient(bwic, client));
    }

    @GetMapping("getRank")
    public ResponseEntity<BidRankDto> getRank(@RequestParam String bwic, @RequestParam String client) {
        return ResponseEntity.ok(this.bidService.getRank(bwic, client));
    }

    @PostMapping("create")
    public ResponseEntity<BidRespondDto> create(@RequestParam String bwic, @RequestParam String client, @RequestParam Double price) {
        return ResponseEntity.ok(this.bidService.createBid(bwic, client, price));
    }

    @PostMapping("update")
    public ResponseEntity<BidRespondDto> update(@RequestParam String bwic, @RequestParam String client, @RequestParam Double price) {
        return ResponseEntity.ok(this.bidService.updateBid(bwic, client, price));
    }

    @PostMapping("updateById")
    public ResponseEntity<BidRespondDto> update(@RequestParam String id, @RequestParam Double price) {
        return ResponseEntity.ok(this.bidService.updateBid(id, price));
    }

    @PostMapping("delete")
    public ResponseEntity<BidRespondDto> delete(@RequestParam String bwic, @RequestParam String client) {
        return ResponseEntity.ok(this.bidService.deleteBid(bwic, client));
    }

    @PostMapping("deleteById")
    public ResponseEntity<BidRespondDto> delete(@RequestParam String id) {
        return ResponseEntity.ok(this.bidService.deleteBid(id));
    }
}
