package com.helpdesk.helpdeskApi.repository;

import com.helpdesk.helpdeskApi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
