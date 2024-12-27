package com.helpdesk.helpdeskApi.mapper;
import com.helpdesk.helpdeskApi.model.*;
import com.helpdesk.helpdeskApi.model.dto.ServiceCallDTO;

import com.helpdesk.helpdeskApi.model.dto.ServiceDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceCallMapper {

    @Mapping(source = "customerId.customerId", target = "customerId")
    @Mapping(source = "deviceId.deviceId", target = "deviceId")
    @Mapping(source = "serviceDetails", target = "serviceDetails")
    ServiceCallDTO sCallToDto(ServiceCall serviceCall);

    @Mapping(source = "customerId", target = "customerId.customerId")
    @Mapping(source = "deviceId", target = "deviceId.deviceId")
    ServiceCall dtoToSCall(ServiceCallDTO serviceCallDTO);

    @Mapping(source = "clerkId", target = "clerkId")
    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "productId", target = "productId")
    ServiceDetails map(ServiceDetailsDTO serviceDetailsDTO);

    // Método para mapear Clerk para Long
    default Long mapClerkToLong(Clerk clerk) {
        return (clerk != null) ? clerk.getClerkId() : null; // Retorna o clerkId ou null se clerk for nulo
    }

    // Método para mapear Product para Long
    default Long mapProductToLong(Product product) {
        return (product != null) ? product.getProductId() : null; // Retorna o productId ou null se product for nulo
    }

    // Método para mapear Customer para Long
    default Long mapCustomerToLong(Customer customer) {
        return (customer != null) ? customer.getCustomerId() : null; // Retorna o customerId ou null se customer for nulo
    }

    // Método para mapear Long para Clerk
    default Clerk mapLongToClerk(Long clerkId) {
        if (clerkId == null) {
            return null;
        }
        Clerk clerk = new Clerk();
        clerk.setClerkId(clerkId);
        return clerk;
    }

    default Product mapProduct(Long productId) {
        if (productId == null) {
            return null;
        }
        Product product = new Product();
        product.setProductId(productId);
        return product;
    }

    default Customer mapCustomer(Long customerId) {
        if (customerId == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        return customer;
    }
}
