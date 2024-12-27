package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.dto.ServiceDetailsDTO;
import org.springframework.stereotype.Service;

@Service
public interface SDetailsService {
    ServiceDetailsDTO updateServiceDetails(Long serviceDetailsId, ServiceDetailsDTO serviceDetailsDTO);
}
