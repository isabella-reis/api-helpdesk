package com.helpdesk.helpdeskApi.controller;

import com.helpdesk.helpdeskApi.model.ServiceCall;
import com.helpdesk.helpdeskApi.model.dto.ServiceCallRequest;
import com.helpdesk.helpdeskApi.service.SCallsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/service-calls")
@RequiredArgsConstructor
public class SCallsController {
    private final SCallsService sCallsService;


    @PostMapping
    public ResponseEntity<ServiceCall> createNewServiceCall(@RequestBody ServiceCallRequest serviceCallRequest) {
        ServiceCall newSCall = sCallsService.createNewServiceCall(serviceCallRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSCall);
    }

    @GetMapping
    public ResponseEntity<Page<ServiceCall>> getAllServiceCalls(Pageable pageable){
        return ResponseEntity.ok(sCallsService.getAllServiceCalls(pageable));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Page<ServiceCall>> getAllServiceCallsByCustomerId(Pageable pageable, @PathVariable("id") Long customerId) {
        Page<ServiceCall> serviceCall = sCallsService.getAllServiceCallsByCustomerId(pageable, customerId);
        return ResponseEntity.ok(serviceCall);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceCall> getServiceCallById(@PathVariable("id") Long serviceId) {
        ServiceCall serviceCall = sCallsService.getServiceCallById(serviceId);
        return ResponseEntity.ok(serviceCall);
    }

}
