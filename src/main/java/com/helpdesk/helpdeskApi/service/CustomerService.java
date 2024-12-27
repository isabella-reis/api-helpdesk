package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.Customer;
import com.helpdesk.helpdeskApi.model.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerById(Long customerId);
    CustomerDTO updateCustomer(Long customerId, CustomerDTO customer);
    Page<CustomerDTO> getAllCustomers(Pageable pageable);
}
