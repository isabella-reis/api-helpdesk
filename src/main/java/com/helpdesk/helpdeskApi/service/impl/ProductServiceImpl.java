package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.model.Product;
import com.helpdesk.helpdeskApi.repository.ProductRepository;
import com.helpdesk.helpdeskApi.service.ProductService;
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
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }
}
