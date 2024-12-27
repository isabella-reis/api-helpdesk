package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.Clerk;
import com.helpdesk.helpdeskApi.model.dto.ClerkDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ClerkService {
    ClerkDTO createNewClerk(ClerkDTO clerkDTO);
    ClerkDTO getClerkById(Long clerkId);
    ClerkDTO updateClerk(Long clerkId, ClerkDTO clerkDTO);
}
