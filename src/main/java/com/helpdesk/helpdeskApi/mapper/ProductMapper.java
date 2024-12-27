package com.helpdesk.helpdeskApi.mapper;
import com.helpdesk.helpdeskApi.model.Product;
import com.helpdesk.helpdeskApi.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToDto(Product product);
    Product dtoToProduct(ProductDTO productDTO);

}
