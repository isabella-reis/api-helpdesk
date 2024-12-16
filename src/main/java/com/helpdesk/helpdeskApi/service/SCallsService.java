package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.Customer;
import com.helpdesk.helpdeskApi.model.Device;
import com.helpdesk.helpdeskApi.model.ServiceCall;
import com.helpdesk.helpdeskApi.model.ServiceStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SCallsService {
    ServiceCall createNewServiceCall(Long customerId, Long deviceId, String serviceReason, Long productId, Long clerkId);
    List<ServiceCall> getAllServiceCalls();
    ServiceCall getServiceCallById(Long customerId);
    List<ServiceCall> getAllServiceCallsByCustomerId(Long customerId);
}
