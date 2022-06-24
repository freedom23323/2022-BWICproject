package com.ebidding.bid.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity // table name
@Getter
@Setter
public class Bid {
    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    private String bwicid;

    private String clientid;

    private Double price;

    private Date biddate;

}

