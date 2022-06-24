package com.ebidding.bid.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BidRespondDto {
    private Integer success;

    private Bid bid;
}
