package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.mapper.ClerkMapper;
import com.helpdesk.helpdeskApi.model.Clerk;
import com.helpdesk.helpdeskApi.model.dto.ClerkDTO;
import com.helpdesk.helpdeskApi.repository.ClerkRepository;
import com.helpdesk.helpdeskApi.service.ClerkService;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClerkServiceImpl implements ClerkService {
    private final ClerkRepository clerkRepository;
    private final ClerkMapper clerkMapper;

    @Override
    public ClerkDTO createNewClerk(ClerkDTO clerkDTO) {
        Clerk clerk = clerkMapper.dtoToClerk(clerkDTO);
        Clerk savedClerk = clerkRepository.save(clerk);
        return clerkMapper.clerkToDto(savedClerk);
    }

    @Override
    public ClerkDTO getClerkById(Long clerkId) {
        Clerk clerk = clerkRepository.findById(clerkId)
                .orElseThrow(() -> new NoResultException("Clerk not found."));
        return clerkMapper.clerkToDto(clerk);
    }

    @Override
    public ClerkDTO updateClerk(Long clerkId, ClerkDTO clerkDTO){
        Clerk existingClerk = clerkRepository.findById(clerkId)
                .orElseThrow(() -> new NoResultException("Clerk not found."));

        existingClerk.setName(clerkDTO.getName());
        Clerk updatedClerk = clerkRepository.save(existingClerk);

        return clerkMapper.clerkToDto(updatedClerk);
    }

}
