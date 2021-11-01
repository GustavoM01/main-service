package com.ironchack.mainservice.service;

import com.ironchack.mainservice.dto.ConvertLeadDTO;
import com.ironchack.mainservice.dto.DecisionMakerDTO;
import com.ironchack.mainservice.dto.OpportunityDTO;
import com.ironchack.mainservice.proxy.ContactProxy;
import com.ironchack.mainservice.proxy.LeadProxy;
import com.ironchack.mainservice.proxy.OpportunityProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("main")
public class MainServiceImp implements MainService{

    private final LeadProxy leadProxy;
    private final ContactProxy contactProxy;
    private final OpportunityProxy opportunityProxy;

    public MainServiceImp(LeadProxy leadProxy, ContactProxy contactProxy, OpportunityProxy opportunityProxy) {
        this.leadProxy = leadProxy;
        this.contactProxy = contactProxy;
        this.opportunityProxy = opportunityProxy;
    }

    @Override
    public OpportunityDTO convertLead(Long id, ConvertLeadDTO convertLeadDTO) {

        DecisionMakerDTO leadToConvert = leadProxy.getLeadInfo(id);
        Long salesRepId = leadToConvert.getSalesRepId();
        DecisionMakerDTO newContact = contactProxy.createContact(leadToConvert);
        leadProxy.delete(id);

        return
                // The passed id gets ignored by the opportunity-service and assigns new id
                opportunityProxy.create(
                        new OpportunityDTO(
                                0L,
                                convertLeadDTO.getProduct(),
                                convertLeadDTO.getQuantity(),
                                newContact.getDecisionMakerId(),
                                0L, // Can be assigned later, deleted (account keeps track of opp) or create account before opp
                                salesRepId));


    }
}
