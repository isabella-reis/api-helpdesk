package com.helpdesk.helpdeskApi.repository;

import com.helpdesk.helpdeskApi.model.Clerk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClerkRepository extends JpaRepository<Clerk, Long> {
}
