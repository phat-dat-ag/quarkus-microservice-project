package org.example.product.repository;

import org.example.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();

    Optional<Product> findById(String id);

    void save(Product product);

    void deleteById(String id);
}
