package com.helpdesk.helpdeskApi.repository;

import com.helpdesk.helpdeskApi.model.ServiceCall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCallRepository extends JpaRepository<ServiceCall, Long> {
}
