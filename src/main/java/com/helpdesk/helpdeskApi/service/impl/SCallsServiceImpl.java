package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.mapper.*;
import com.helpdesk.helpdeskApi.model.*;

import com.helpdesk.helpdeskApi.model.dto.*;
import com.helpdesk.helpdeskApi.repository.ServiceCallRepository;

import com.helpdesk.helpdeskApi.repository.ServiceDetailsRepository;
import com.helpdesk.helpdeskApi.service.*;

import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SCallsServiceImpl implements SCallsService {

    private final ServiceCallRepository serviceCallRepository;
    //Service Call communicates directly with ServiceDetails Repository because ServiceDetails is a part of ServiceCall.
    private final ServiceDetailsRepository serviceDetailsRepository;
    private final CustomerService customerService;
    private final DeviceService deviceService;
    private final ProductService productService;
    private final ClerkService clerkService;

    @Transactional
    @Override
    public ServiceCallDTO createNewServiceCall (ServiceCallDTO serviceCallDTO, ServiceDetailsDTO serviceDetailsDTO) {

        CustomerDTO customerDTO = customerService.getCustomerById(serviceCallDTO.getCustomerId());
        Customer customer = CustomerMapper.INSTANCE.dtoToCustomer(customerDTO);

        DeviceDTO deviceDTO = deviceService.getDeviceById(serviceCallDTO.getDeviceId());
        Device device = DeviceMapper.INSTANCE.dtoToDevice(deviceDTO);

        ProductDTO productDTO = productService.getProductById(serviceDetailsDTO.getProductId());
        Product product = ProductMapper.INSTANCE.dtoToProduct(productDTO);

        ClerkDTO clerkDTO = clerkService.getClerkById(serviceDetailsDTO.getClerkId());
        Clerk clerk = ClerkMapper.INSTANCE.dtoToClerk(clerkDTO);


        // Criação da nova ServiceCall
        ServiceCall newServiceCall = ServiceCallMapper.INSTANCE.dtoToSCall(serviceCallDTO);
        newServiceCall.setCustomerId(customer);
        newServiceCall.setDeviceId(device);
        newServiceCall.setServiceStatus(ServiceStatus.ABERTO);

        // Persistir a nova ServiceCall
        newServiceCall = serviceCallRepository.save(newServiceCall);

        ServiceDetails serviceDetails = ServiceDetailsMapper.INSTANCE.dtoToSDetails(serviceDetailsDTO);
        serviceDetails.setProductId(product);
        serviceDetails.setCustomerId(customer);
        serviceDetails.setClerkId(clerk);
        serviceDetails.setServiceCall(newServiceCall);

        serviceDetailsRepository.save(serviceDetails);

        // Retornar o DTO da nova ServiceCall
        return ServiceCallMapper.INSTANCE.sCallToDto(newServiceCall);
    }

    @Override
    public Page<ServiceCallDTO> getAllServiceCalls(Pageable pageable) {
        Page<ServiceCall> serviceCallPage = serviceCallRepository.findAll(pageable);
        List<ServiceCallDTO> serviceCallDTOs = serviceCallPage.getContent().stream()
                .map(ServiceCallMapper.INSTANCE::sCallToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(serviceCallDTOs, pageable, serviceCallPage.getTotalElements());
    }

    @Override
    public ServiceCallDTO getServiceCallById(Long serviceId) {
        ServiceCall serviceCall = serviceCallRepository.findById(serviceId)
                .orElseThrow(() -> new NoResultException("Service Call not found. ID: " + serviceId));
        return ServiceCallMapper.INSTANCE.sCallToDto(serviceCall);
    }

    @Override
    public ServiceCallDTO updateServiceCall(Long serviceId, ServiceCallDTO serviceCallDTO) {
        ServiceCall existingServiceCall = serviceCallRepository.findById(serviceId)
                .orElseThrow(() -> new NoResultException("Service Call not found."));

        //O usuario pode alterar o status e o device
        existingServiceCall.setServiceStatus(ServiceStatus.valueOf(serviceCallDTO.getServiceStatus())); // Atribui o enum correspondente

        DeviceDTO deviceDTO = deviceService.getDeviceById(serviceCallDTO.getDeviceId());
        Device device = DeviceMapper.INSTANCE.dtoToDevice(deviceDTO);
        existingServiceCall.setDeviceId(device);

        ServiceCall updatedServiceCall = serviceCallRepository.save(existingServiceCall);

        return ServiceCallMapper.INSTANCE.sCallToDto(updatedServiceCall);
    }

    @Override
    public Page<ServiceCallDTO> getAllServiceCallsByCustomerId(Pageable pageable, Long customerId) {
        Page<ServiceCall> serviceCallPage = serviceCallRepository.findByCustomerId(pageable, customerId);
        List<ServiceCallDTO> serviceCallDTOs = serviceCallPage.getContent().stream()
                .map(ServiceCallMapper.INSTANCE::sCallToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(serviceCallDTOs, pageable, serviceCallPage.getTotalElements());
    }
}
