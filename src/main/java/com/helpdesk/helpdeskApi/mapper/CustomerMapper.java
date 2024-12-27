package com.helpdesk.helpdeskApi.mapper;
import com.helpdesk.helpdeskApi.model.Customer;
import com.helpdesk.helpdeskApi.model.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO customerToDto(Customer customer);
    Customer dtoToCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> customersToDtos(List<Customer> customers);

}
