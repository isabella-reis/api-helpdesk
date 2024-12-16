package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.model.Clerk;
import com.helpdesk.helpdeskApi.repository.ClerkRepository;
import com.helpdesk.helpdeskApi.service.ClerkService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClerkServiceImpl implements ClerkService {
    private final ClerkRepository clerkRepository;

    public ClerkServiceImpl(ClerkRepository clerkRepository) {
        this.clerkRepository = clerkRepository;
    }

    @Override
    public Optional<Clerk> getClerkById(Long clerkId) {
        return clerkRepository.findById(clerkId);
    }
}
