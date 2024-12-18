package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.ServiceCall;
import com.helpdesk.helpdeskApi.model.dto.ServiceCallRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SCallsService {
    ServiceCall createNewServiceCall(ServiceCallRequest serviceCallRequest);
    Page<ServiceCall> getAllServiceCalls(Pageable pageable);
    ServiceCall getServiceCallById(Long customerId);
    Page<ServiceCall> getAllServiceCallsByCustomerId(Pageable pageable, Long customerId);
}
