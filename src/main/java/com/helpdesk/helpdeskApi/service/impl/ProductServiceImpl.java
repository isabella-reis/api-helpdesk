package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.mapper.ProductMapper;
import com.helpdesk.helpdeskApi.model.Product;
import com.helpdesk.helpdeskApi.model.dto.ProductDTO;
import com.helpdesk.helpdeskApi.repository.ProductRepository;
import com.helpdesk.helpdeskApi.service.ProductService;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO createNewProduct(ProductDTO productDTO) {
        Product product = productMapper.dtoToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.productToDto(savedProduct);
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoResultException("Product not found."));
        return productMapper.productToDto(product);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new NoResultException("Product not found."));

        existingProduct.setName(productDTO.getName());
        Product updatedProduct = productRepository.save(existingProduct);

        return productMapper.productToDto(updatedProduct);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

}
