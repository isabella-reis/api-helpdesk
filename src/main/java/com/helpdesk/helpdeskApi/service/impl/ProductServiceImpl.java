package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.mapper.ProductMapper;
import com.helpdesk.helpdeskApi.model.Product;
import com.helpdesk.helpdeskApi.model.dto.ProductDTO;
import com.helpdesk.helpdeskApi.repository.ProductRepository;
import com.helpdesk.helpdeskApi.service.ProductService;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public boolean doesProductExist(Long productId) {
        return productRepository.existsById(productId);
    }

    @Override
    public ProductDTO createNewProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.dtoToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.INSTANCE.productToDto(savedProduct);
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoResultException("Product not found."));
        return ProductMapper.INSTANCE.productToDto(product);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new NoResultException("Product not found."));

        existingProduct.setName(productDTO.getName());
        Product updatedProduct = productRepository.save(existingProduct);

        return ProductMapper.INSTANCE.productToDto(updatedProduct);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

}
