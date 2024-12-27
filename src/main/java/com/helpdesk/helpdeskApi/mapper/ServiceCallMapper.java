package com.helpdesk.helpdeskApi.mapper;
import com.helpdesk.helpdeskApi.model.ServiceCall;
import com.helpdesk.helpdeskApi.model.dto.ServiceCallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ServiceCallMapper {

    ServiceCallMapper INSTANCE = Mappers.getMapper( ServiceCallMapper.class );

    ServiceCallDTO sCallToDto(ServiceCall serviceCall);
    ServiceCall dtoToSCall(ServiceCallDTO serviceCallDTO);
    List<ServiceCallDTO> sCallsToDtos(List<ServiceCall> serviceCalls);

}
