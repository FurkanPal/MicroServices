package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan

public interface ProductRepository extends JpaRepository<Product, String> {

}
