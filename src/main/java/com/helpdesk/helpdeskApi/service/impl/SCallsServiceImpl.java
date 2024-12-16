package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.model.*;

import com.helpdesk.helpdeskApi.repository.ServiceCallRepository;

import com.helpdesk.helpdeskApi.repository.ServiceDetailsRepository;
import com.helpdesk.helpdeskApi.service.*;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SCallsServiceImpl implements SCallsService {

    private final ServiceCallRepository serviceCallRepository;
    private final ServiceDetailsRepository serviceDetailsRepository;
    private final CustomerService customerService;
    private final DeviceService deviceService;
    private final ProductService productService;
    private final ClerkService clerkService;


    @Autowired
    public SCallsServiceImpl(ServiceCallRepository serviceCallRepository, ServiceDetailsRepository serviceDetailsRepository,
                             CustomerService customerService, DeviceService deviceService, ProductService productService, ClerkService clerkService) {
        this.serviceCallRepository = serviceCallRepository;
        this.serviceDetailsRepository = serviceDetailsRepository;
        this.customerService = customerService;
        this.deviceService = deviceService;
        this.productService = productService;
        this.clerkService = clerkService;
    }

    @Transactional
    @Override
    public ServiceCall createNewServiceCall (Long customerId, Long deviceId, String serviceReason, Long productId, Long clerkId) {
        Optional<Customer> optionalCustomer = customerService.getCustomerById(customerId);
        Customer customer = optionalCustomer.get();

        Optional<Device> optionalDevice = deviceService.getDeviceById(deviceId);
        Device device = optionalDevice.get();

        ServiceCall newServiceCall = new ServiceCall();

        newServiceCall.setCustomer(customer);
        newServiceCall.setDevice(device);
        newServiceCall.setServiceStatus(ServiceStatus.ABERTO);

        newServiceCall = serviceCallRepository.save(newServiceCall);

        // Create Details for ServiceCall
        Optional<Product> optionalProduct = productService.getProductById(productId);
        Product product = optionalProduct.get();

        Optional<Clerk> optionalClerk = clerkService.getClerkById(clerkId);
        Clerk clerk = optionalClerk.get();

        ServiceDetails serviceDetails = new ServiceDetails();

        serviceDetails.setServiceReason(serviceReason);
        serviceDetails.setProduct(product);
        serviceDetails.setCustomer(newServiceCall.getCustomer());
        serviceDetails.setClerk(clerk);
        serviceDetails.setServiceCall(newServiceCall);

        serviceDetailsRepository.save(serviceDetails);

        return newServiceCall;
    }

    @Override
    public List<ServiceCall> getAllServiceCalls() {
        return serviceCallRepository.findAll();
    }

    @Override
    public ServiceCall getServiceCallById(Long serviceId) {
        return serviceCallRepository.findById(serviceId)
                .orElseThrow(() -> new EntityNotFoundException("Service Call not found"));
    }

    @Override
    public List<ServiceCall> getAllServiceCallsByCustomerId(Long customerId) {
        return serviceCallRepository.findByCustomerId(customerId);
    }
}
