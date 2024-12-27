package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.mapper.ClerkMapper;
import com.helpdesk.helpdeskApi.mapper.ServiceDetailsMapper;
import com.helpdesk.helpdeskApi.model.Clerk;
import com.helpdesk.helpdeskApi.model.ServiceDetails;
import com.helpdesk.helpdeskApi.model.dto.ClerkDTO;
import com.helpdesk.helpdeskApi.model.dto.ServiceDetailsDTO;
import com.helpdesk.helpdeskApi.repository.ServiceDetailsRepository;
import com.helpdesk.helpdeskApi.service.ClerkService;
import com.helpdesk.helpdeskApi.service.SDetailsService;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SDetailsServiceImpl implements SDetailsService {
    private final ServiceDetailsRepository serviceDetailsRepository;
    private final ClerkService clerkService;
    private final ServiceDetailsMapper serviceDetailsMapper;
    private final ClerkMapper clerkMapper;


    @Transactional
    @Override
    public ServiceDetailsDTO updateServiceDetails(Long serviceDetailsId, ServiceDetailsDTO serviceDetailsDTO) {
        ServiceDetails existingServiceDetails = serviceDetailsRepository.findById(serviceDetailsId)
                .orElseThrow(() -> new NoResultException("Service Details not found."));

        // Atualizar campos de ServiceDetails
        existingServiceDetails.setServiceReason(serviceDetailsDTO.getServiceReason());
        existingServiceDetails.setDtResolution(serviceDetailsDTO.getDtResolution());

        ClerkDTO clerkDTO = clerkService.getClerkById(serviceDetailsDTO.getClerkId());
        Clerk clerk = clerkMapper.dtoToClerk(clerkDTO);
        existingServiceDetails.setClerkId(clerk);

        ServiceDetails updatedServiceDetails = serviceDetailsRepository.save(existingServiceDetails);

        return serviceDetailsMapper.sdetailsToDto(updatedServiceDetails);
    }
}
