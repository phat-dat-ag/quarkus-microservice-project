package org.example.product.factory;

import org.example.product.entity.Product;

public class ProductTestFactory {
    public static Product createValidProduct() {
        Product product = new Product();
        product.name = "Laptop ASUS";
        product.description = "Danh cho sinh vien";
        product.price = 12000000;
        product.quantity = 100;

        return product;
    }

    public static Product createInvalidProduct(){
        Product product = new Product();
        product.name = "Laptop ASUS";
        product.description = "Danh cho sinh vien";
        product.price = 12000000;
        product.quantity = 3;

        return product;
    }
}
