package com.helpdesk.helpdeskApi.mapper;

import com.helpdesk.helpdeskApi.model.Clerk;
import com.helpdesk.helpdeskApi.model.Customer;
import com.helpdesk.helpdeskApi.model.Product;
import com.helpdesk.helpdeskApi.model.ServiceDetails;
import com.helpdesk.helpdeskApi.model.dto.ServiceDetailsDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceDetailsMapper {

    @Mapping(source = "productId.productId", target = "productId")
    @Mapping(source = "customerId.customerId", target = "customerId")
    @Mapping(source = "clerkId.clerkId", target = "clerkId")
    ServiceDetailsDTO sdetailsToDto(ServiceDetails serviceDetails);

    @Mapping(source = "productId", target = "productId.productId")
    @Mapping(source = "customerId", target = "customerId.customerId")
    @Mapping(source = "clerkId", target = "clerkId.clerkId")
    ServiceDetails dtoToSDetails(ServiceDetailsDTO serviceDetailsDTO);

    List<ServiceDetails> map(List<ServiceDetailsDTO> serviceDetailsDTOs);


}
