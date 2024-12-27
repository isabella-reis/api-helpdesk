package com.helpdesk.helpdeskApi.controller;

import com.helpdesk.helpdeskApi.model.dto.NewServiceCallRequest;
import com.helpdesk.helpdeskApi.model.dto.ServiceCallDTO;
import com.helpdesk.helpdeskApi.service.SCallsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/service-calls")
@RequiredArgsConstructor
public class SCallsController {
    private final SCallsService serviceCallsService;


    @PostMapping
    public ResponseEntity<ServiceCallDTO> createNewServiceCall(@RequestBody NewServiceCallRequest newServiceCallRequest) {
        ServiceCallDTO newSCallDTO = serviceCallsService.createNewServiceCall(newServiceCallRequest.getServiceCallDTO(),
                newServiceCallRequest.getServiceDetailsDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(newSCallDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ServiceCallDTO>> getAllServiceCalls(Pageable pageable){
        return ResponseEntity.ok(serviceCallsService.getAllServiceCalls(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceCallDTO> getServiceCallById(@PathVariable("id") Long id) {
        ServiceCallDTO serviceCallDTO = serviceCallsService.getServiceCallById(id);
        return ResponseEntity.ok(serviceCallDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceCallDTO> updateServiceCall(@PathVariable Long id, @RequestBody ServiceCallDTO serviceCallDTO) {
        ServiceCallDTO updatedServiceCallDTO = serviceCallsService.updateServiceCall(id, serviceCallDTO);
        return ResponseEntity.ok(updatedServiceCallDTO);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Page<ServiceCallDTO>> getAllServiceCallsByCustomerId(Pageable pageable, @PathVariable Long id) {
        Page<ServiceCallDTO> serviceCalls = serviceCallsService.getAllServiceCallsByCustomerId(pageable, id);
        return ResponseEntity.ok(serviceCalls);
    }

}
