package com.ironchack.mainservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConvertLeadDTO {

    // Data that can be supplied by request
    private String product;
    private Integer quantity;
    // Account data
    private Long accountId;
    private String industry;
    private Integer employeeCount;
    private String city;
    private String country;
    private List<Long> contactList;
    private List<Long> opportunityList;
}
