package com.helpdesk.helpdeskApi.controller;

import com.helpdesk.helpdeskApi.model.dto.ServiceDetailsDTO;
import com.helpdesk.helpdeskApi.service.SDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service-call-details")
@RequiredArgsConstructor
public class SDetailsController {

    private final SDetailsService sDetailsService;

    @PutMapping("/{id}")
    public ResponseEntity<ServiceDetailsDTO> updateServiceDetails(@PathVariable("id") Long id, @RequestBody ServiceDetailsDTO serviceDetailsDTO) {
        ServiceDetailsDTO updatedServiceDetailsDTO = sDetailsService.updateServiceDetails(id, serviceDetailsDTO);
        return ResponseEntity.ok(updatedServiceDetailsDTO);
    }
}
