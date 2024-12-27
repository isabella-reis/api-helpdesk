package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductDTO createNewProduct(ProductDTO productDTO);
    ProductDTO getProductById (Long productId);
    ProductDTO updateProduct(Long productId, ProductDTO productDTO);
    void deleteProductById(Long productId);
}
