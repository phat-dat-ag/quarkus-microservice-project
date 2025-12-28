package org.example.product.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.example.product.entity.Product;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll() {
        return Product.listAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(Product.findById(new ObjectId(id)));
    }

    @Override
    public void save(Product product) {
        product.persist();
    }

    @Override
    public void deleteById(String id) {
        Product.deleteById(new ObjectId(id));
    }
}
