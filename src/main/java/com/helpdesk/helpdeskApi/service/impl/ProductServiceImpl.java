package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.model.Product;
import com.helpdesk.helpdeskApi.repository.ProductRepository;
import com.helpdesk.helpdeskApi.service.ProductService;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }
}
