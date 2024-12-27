package com.helpdesk.helpdeskApi.mapper;
import com.helpdesk.helpdeskApi.model.Product;
import com.helpdesk.helpdeskApi.model.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO productToDto(Product product);
    Product dtoToProduct(ProductDTO productDTO);

}
