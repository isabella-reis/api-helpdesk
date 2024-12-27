package com.helpdesk.helpdeskApi.controller;

import com.helpdesk.helpdeskApi.model.dto.ClerkDTO;
import com.helpdesk.helpdeskApi.service.ClerkService;
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
@RequestMapping("/api/clerks")
@RequiredArgsConstructor
public class ClerkController {
    private final ClerkService clerkService;

    @PostMapping
    public ResponseEntity<ClerkDTO> createNewClerk(@RequestBody ClerkDTO clerkDTO) {
        ClerkDTO newClerk = clerkService.createNewClerk(clerkDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClerk);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClerkDTO> getClerkById(@PathVariable Long id) {
        ClerkDTO clerkDTO = clerkService.getClerkById(id);
        return ResponseEntity.ok(clerkDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClerkDTO> updateClerk(@PathVariable Long id, @RequestBody ClerkDTO clerkDTO) {
        ClerkDTO updatedClerk = clerkService.updateClerk(id, clerkDTO);
        return ResponseEntity.ok(updatedClerk);
    }
}
