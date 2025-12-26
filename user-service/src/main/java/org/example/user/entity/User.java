package org.example.user.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity {
    public String name;
    public String email;
    public int age;
}