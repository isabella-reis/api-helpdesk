package com.helpdesk.helpdeskApi.mapper;

import com.helpdesk.helpdeskApi.model.Clerk;
import com.helpdesk.helpdeskApi.model.dto.ClerkDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClerkMapper {

    ClerkMapper INSTANCE = Mappers.getMapper(ClerkMapper.class);

    ClerkDTO clerkToDto(Clerk clerk);
    Clerk dtoToClerk(ClerkDTO clerkDTO);

}
