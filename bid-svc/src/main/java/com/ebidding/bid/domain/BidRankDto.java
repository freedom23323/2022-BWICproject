package com.ebidding.bid.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BidRankDto {
    private Integer success;

    private Integer currentRank;

    private Integer totalRank;

    private Double secondPrice;
}
