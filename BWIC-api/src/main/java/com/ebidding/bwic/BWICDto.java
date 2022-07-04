package com.ebidding.bwic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BWICDto {
    private Integer id;

    private String cusip;

    private Integer size;

    private Integer startingprice;

    private Date duedate;
}
