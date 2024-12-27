package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.ServiceCall;
import com.helpdesk.helpdeskApi.model.dto.ServiceCallDTO;
import com.helpdesk.helpdeskApi.model.dto.ServiceDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface SCallsService {
    ServiceCallDTO createNewServiceCall(ServiceCallDTO serviceCallDTO, ServiceDetailsDTO serviceDetailsDTO);
    Page<ServiceCallDTO> getAllServiceCalls(Pageable pageable);
    ServiceCallDTO getServiceCallById(Long serviceId);
    ServiceCallDTO updateServiceCall(Long serviceCallId, ServiceCallDTO serviceCallDTO);
    Page<ServiceCallDTO> getAllServiceCallsByCustomerId(Pageable pageable, Long customerId);
}
