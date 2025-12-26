package org.example.product.dto;

import org.example.product.entity.Product;

public class ProductDTO {
    public String id;
    public String name;
    public String description;
    public int price;
    public int quantity;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.id.toString();
        this.name = product.name;
        this.description = product.description;
        this.price = product.price;
        this.quantity = product.quantity;
    }
}
