package com.helpdesk.helpdeskApi.repository;

import com.helpdesk.helpdeskApi.model.ServiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDetailsRepository extends JpaRepository<ServiceDetails, Long> {
}
