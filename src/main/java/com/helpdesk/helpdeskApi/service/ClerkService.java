package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.Clerk;

import java.util.Optional;

public interface ClerkService {
    Optional<Clerk> getClerkById(Long clerkId);

}
