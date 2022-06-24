package com.ebidding.bid.repository;

import com.ebidding.bid.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid, String> {
    Optional<Bid> findByBwicidAndClientid(String bid,String cid);
    Optional<Bid> findById(String id);

    Optional<List<Bid>> findByBwicid(String bwic);

    Optional<List<Bid>> findByClientid(String client);
}
