package com.ironchack.mainservice.service;

import com.ironchack.mainservice.dto.ConvertLeadDTO;
import com.ironchack.mainservice.dto.DecisionMakerDTO;
import com.ironchack.mainservice.dto.OpportunityDTO;

public interface MainService {

    OpportunityDTO convertLead(Long id, ConvertLeadDTO convertLeadDTO);
}
