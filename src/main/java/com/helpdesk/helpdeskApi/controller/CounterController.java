package com.helpdesk.helpdeskApi.controller;

import com.helpdesk.helpdeskApi.model.Counter;
import com.helpdesk.helpdeskApi.model.dto.CounterDTO;
import com.helpdesk.helpdeskApi.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/counters")
@RequiredArgsConstructor
public class CounterController {
    private final CounterService counterService;

    @PostMapping
    public ResponseEntity<CounterDTO> createNewCounter(@RequestBody CounterDTO counterDTO) {
        CounterDTO newCounter = counterService.createNewCounter(counterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCounter);
    }
}
