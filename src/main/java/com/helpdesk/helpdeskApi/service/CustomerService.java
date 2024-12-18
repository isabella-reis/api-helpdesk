package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    Customer createNewCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
    Page<Customer> getAllCustomers(Page pageable);
}
