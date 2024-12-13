package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById (Long productId);

}
