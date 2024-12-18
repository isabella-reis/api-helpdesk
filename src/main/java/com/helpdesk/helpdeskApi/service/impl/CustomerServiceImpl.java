package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.model.Customer;
import com.helpdesk.helpdeskApi.repository.CustomerRepository;
import com.helpdesk.helpdeskApi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer createNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(new Customer()); // Throw Exception - Criar
    }

    @Override
    public Page<Customer> getAllCustomers(Page pageable) {
        return customerRepository.findAll((Pageable) pageable);
    }
}
