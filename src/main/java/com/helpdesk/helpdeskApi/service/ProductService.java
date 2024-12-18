package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {
    Optional<Product> getProductById (Long productId);
    boolean doesProductExist(Long productId);
}
