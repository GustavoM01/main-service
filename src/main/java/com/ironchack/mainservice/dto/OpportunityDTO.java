package com.ironchack.mainservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpportunityDTO {

    private Long id;

    private String product;

    private Integer quantity;

    private Long decisionMaker;

    private Long account;

    private Long salesRep;
}
