package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.Clerk;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ClerkService {
    Optional<Clerk> getClerkById(Long clerkId);

}
