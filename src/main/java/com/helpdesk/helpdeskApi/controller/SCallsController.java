package com.helpdesk.helpdeskApi.controller;

import com.helpdesk.helpdeskApi.model.Clerk;
import com.helpdesk.helpdeskApi.model.ServiceCall;
import com.helpdesk.helpdeskApi.model.ServiceDetails;
import com.helpdesk.helpdeskApi.model.dto.ServiceCallRequest;
import com.helpdesk.helpdeskApi.repository.ServiceDetailsRepository;
import com.helpdesk.helpdeskApi.service.ClerkService;
import com.helpdesk.helpdeskApi.service.SCallsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/service-calls")
public class SCallsController {
    private final SCallsService SCallsService;
    private final ServiceDetailsRepository serviceDetailsRepository;
    private final ClerkService clerkService;

    @Autowired
    public SCallsController(SCallsService SCallsService, ServiceDetailsRepository serviceDetailsRepository, ClerkService clerkService) {
        this.SCallsService = SCallsService;
        this.serviceDetailsRepository = serviceDetailsRepository;
        this.clerkService = clerkService;
    }

    @PostMapping
    public ResponseEntity<ServiceCall> createNewServiceCall(@RequestBody ServiceCallRequest serviceCallRequest) {

        Optional<Clerk> optionalClerk = clerkService.getClerkById(serviceCallRequest.getClerkId());
        if (!optionalClerk.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        ServiceCall newSCall = SCallsService.createNewServiceCall(
                serviceCallRequest.getCustomerId(),
                serviceCallRequest.getDeviceId(),
                serviceCallRequest.getServiceReason(),
                serviceCallRequest.getProductId(),
                serviceCallRequest.getClerkId()
        );

        ServiceDetails newSDetails = new ServiceDetails();
        newSDetails.setServiceCall(newSCall);
        newSDetails.setServiceReason(serviceCallRequest.getServiceReason());
        newSDetails.setClerk(optionalClerk.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(newSCall);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceCall> getServiceCallById(@PathVariable("id") Long serviceId) {
        ServiceCall serviceCall = SCallsService.getServiceCallById(serviceId);
        return ResponseEntity.ok(serviceCall);
    }

}
