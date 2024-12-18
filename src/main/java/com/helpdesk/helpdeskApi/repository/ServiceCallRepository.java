package com.helpdesk.helpdeskApi.repository;

import com.helpdesk.helpdeskApi.model.ServiceCall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceCallRepository extends JpaRepository<ServiceCall, Long> {
    @Query("SELECT s FROM ServiceCall s WHERE s.customer.customerId = ?1")
    Page<ServiceCall> findByCustomerId(Pageable page, Long customerId);
}
