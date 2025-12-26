package org.example.product.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "products")
public class Product extends PanacheMongoEntity {
    public String name;
    public String description;
    public int price;
    public int quantity;
}
