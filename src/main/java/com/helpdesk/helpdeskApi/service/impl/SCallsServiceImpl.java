package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.model.*;

import com.helpdesk.helpdeskApi.repository.ServiceCallRepository;

import com.helpdesk.helpdeskApi.repository.ServiceDetailsRepository;
import com.helpdesk.helpdeskApi.service.*;

import com.helpdesk.helpdeskApi.model.dto.ServiceCallRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SCallsServiceImpl implements SCallsService {

    private final ServiceCallRepository serviceCallRepository;
    private final ServiceDetailsRepository serviceDetailsRepository;
    private final CustomerService customerService;
    private final DeviceService deviceService;
    private final ProductService productService;
    private final ClerkService clerkService;

    private void assertDeviceExists(Long deviceId) {
        if (!deviceService.doesDeviceExist(deviceId)) {
            throw new EntityNotFoundException("Device not found.");
        }
    }

    private void assertClerkExists(Long clerkId) {
        if (!deviceService.doesDeviceExist(clerkId)) {
            throw new EntityNotFoundException("Device not found.");
        }
    }

    private void assertProductExists(Long productId) {
        if (!productService.doesProductExist(productId)) {
            throw new EntityNotFoundException("Product not found.");
        }
    }


    @Transactional
    @Override
    public ServiceCall createNewServiceCall (ServiceCallRequest serviceCallRequest) {
        assertClerkExists(serviceCallRequest.getClerkId());
        assertDeviceExists(serviceCallRequest.getDeviceId());
        assertProductExists(serviceCallRequest.getProductId());

        Customer customer = customerService.getCustomerById(serviceCallRequest.getCustomerId());
        Device device = deviceService.getDeviceById(serviceCallRequest.getDeviceId()).get();
        Product product = productService.getProductById(serviceCallRequest.getProductId()).get();
        Clerk clerk = clerkService.getClerkById(serviceCallRequest.getClerkId()).get();

        //ServiceCall #PESQUISAR POR MAPPER
        ServiceCall newServiceCall = new ServiceCall();
        newServiceCall.setCustomer(customer);
        newServiceCall.setDevice(device);
        newServiceCall.setServiceStatus(ServiceStatus.ABERTO);
        newServiceCall = serviceCallRepository.save(newServiceCall);

        //Details for ServiceCall #PESQUISAR POR MAPPER
        ServiceDetails serviceDetails = new ServiceDetails();
        serviceDetails.setServiceReason(serviceCallRequest.getServiceReason());
        serviceDetails.setProduct(product);
        serviceDetails.setCustomer(newServiceCall.getCustomer());
        serviceDetails.setClerk(clerk);
        serviceDetails.setServiceCall(newServiceCall);
        serviceDetailsRepository.save(serviceDetails);

        return newServiceCall;
    }

    @Override
    public Page<ServiceCall> getAllServiceCalls(Pageable pageable) {
        return serviceCallRepository.findAll(pageable);
    }

    @Override
    public ServiceCall getServiceCallById(Long serviceId) {
        return serviceCallRepository.findById(serviceId)
                .orElseThrow(() -> new EntityNotFoundException("Service Call not found"));
    }

    @Override
    public Page<ServiceCall> getAllServiceCallsByCustomerId(Pageable pageable, Long customerId) {
        return serviceCallRepository.findByCustomerId(pageable, customerId);
    }
}
