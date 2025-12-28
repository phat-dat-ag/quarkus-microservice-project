package org.example.product.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.product.entity.Product;
import org.example.product.repository.ProductRepository;

import java.util.List;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Product not found")
        );
    }

    public void createProduct(Product product) {
        if (product.quantity < 10)
            throw new IllegalArgumentException("quantity should be greater or equal to 10");
        productRepository.save(product);
    }

    public void updateProduct(String id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Product not found")
        );
        product.name = updatedProduct.name;
        product.description = updatedProduct.description;
        product.price = updatedProduct.price;
        product.quantity = updatedProduct.quantity;

        productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
