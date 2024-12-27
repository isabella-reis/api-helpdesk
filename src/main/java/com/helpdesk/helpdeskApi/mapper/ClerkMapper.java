package com.helpdesk.helpdeskApi.mapper;

import com.helpdesk.helpdeskApi.model.Clerk;
import com.helpdesk.helpdeskApi.model.dto.ClerkDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClerkMapper {

    ClerkDTO clerkToDto(Clerk clerk);
    Clerk dtoToClerk(ClerkDTO clerkDTO);

}
