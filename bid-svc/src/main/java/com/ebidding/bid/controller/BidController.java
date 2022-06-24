package com.ebidding.bid.controller;

import com.ebidding.bid.domain.Bid;
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
    public ResponseEntity<Optional<List<Bid>>> getBitByClient(@RequestParam String id) {
        return ResponseEntity.ok(this.bidService.getBidByClient(id));
    }

    @GetMapping("findByBwic")
    public ResponseEntity<Optional<List<Bid>>> getBitByBwic(@RequestParam String id) {
        return ResponseEntity.ok(this.bidService.getBidByBwic(id));
    }

    @GetMapping("findByBwicAndClient")
    public ResponseEntity<Optional<Bid>> getBitByBwicAndClient(@RequestParam String bid,@RequestParam String cid) {
        return ResponseEntity.ok(this.bidService.getBidByBwicAndClient(bid,cid));
    }

    @PostMapping("create")
    public ResponseEntity<Optional<Bid>> create(@RequestParam String bwic,@RequestParam String client,@RequestParam Double price) {
        return ResponseEntity.ok(this.bidService.createBid(bwic,client,price));
    }
}
