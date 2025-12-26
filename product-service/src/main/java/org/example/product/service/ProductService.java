package org.example.product.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.example.product.entity.Product;

import java.util.List;

@ApplicationScoped
public class ProductService {
    public List<Product> getAllProducts() {
        return Product.listAll();
    }

    public Product getProductById(String id) {
        return Product.findById(new ObjectId(id));
    }

    public void createProduct(Product product) {
        product.persist();
    }

    public void updateProduct(String id, Product updatedProduct) {
        Product product = Product.findById(new ObjectId(id));
        if (product != null) {
            product.name = updatedProduct.name;
            product.description = updatedProduct.description;
            product.price = updatedProduct.price;
            product.quantity = updatedProduct.quantity;
            product.persistOrUpdate();
        }
    }

    public void deleteProduct(String id) {
        Product.deleteById(new ObjectId(id));
    }
}
