package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.mapper.CustomerMapper;
import com.helpdesk.helpdeskApi.model.Customer;
import com.helpdesk.helpdeskApi.model.dto.CustomerDTO;
import com.helpdesk.helpdeskApi.repository.CustomerRepository;
import com.helpdesk.helpdeskApi.service.CustomerService;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.dtoToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToDto(savedCustomer);
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoResultException("Customer not found."));

        return customerMapper.customerToDto(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO) {

        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoResultException("Customer not found."));

        existingCustomer.setName(customerDTO.getName());
        existingCustomer.setEmail(customerDTO.getEmail());
        Customer updatedCustomer = customerRepository.save(existingCustomer);

        return customerMapper.customerToDto(updatedCustomer);
    }

    @Override
    public Page<CustomerDTO> getAllCustomers(Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findAll(pageable);

        List<CustomerDTO> customers = customerMapper.customersToDtos(customerPage.getContent());

        return new PageImpl<>(customers, pageable, customerPage.getTotalElements());

    }
}
