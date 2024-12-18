package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.model.Clerk;
import com.helpdesk.helpdeskApi.repository.ClerkRepository;
import com.helpdesk.helpdeskApi.service.ClerkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClerkServiceImpl implements ClerkService {
    private final ClerkRepository clerkRepository;

    @Override
    public boolean doesClerkExist(Long clerkId) {
        return clerkRepository.existsById(clerkId);
    }

    @Override
    public Optional<Clerk> getClerkById(Long clerkId) {
        return clerkRepository.findById(clerkId);
    }
}
