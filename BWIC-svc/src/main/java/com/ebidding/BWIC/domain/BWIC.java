package com.ebidding.BWIC.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "bwic")// table name
@Data
@NoArgsConstructor
public class BWIC {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY) //主键自增
    private Integer id;

    private String cusip;

    private Integer size;

    private Integer startingprice;

    private Date duedate;


    //private AccountRole role;

}
