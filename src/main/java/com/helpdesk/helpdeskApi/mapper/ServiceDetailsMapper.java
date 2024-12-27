package com.helpdesk.helpdeskApi.mapper;
import com.helpdesk.helpdeskApi.model.ServiceDetails;
import com.helpdesk.helpdeskApi.model.dto.ServiceDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceDetailsMapper {

    ServiceDetailsMapper INSTANCE = Mappers.getMapper( ServiceDetailsMapper.class );

    ServiceDetailsDTO sdetailsToDto(ServiceDetails serviceDetails);
    ServiceDetails dtoToSDetails(ServiceDetailsDTO serviceDetailsDTO);

}
