package com.helpdesk.helpdeskApi.repository;

import com.helpdesk.helpdeskApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
