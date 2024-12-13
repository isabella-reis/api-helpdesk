package com.helpdesk.helpdeskApi.repository;

import com.helpdesk.helpdeskApi.model.ServiceCall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceCallRepository extends JpaRepository<ServiceCall, Long> {
    List<ServiceCall> findByCustomerId(Long customerId);
}
