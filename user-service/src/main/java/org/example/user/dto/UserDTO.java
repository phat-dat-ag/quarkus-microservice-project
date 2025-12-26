package org.example.user.dto;

import org.example.user.entity.User;

public class UserDTO {
    public String id;
    public String name;
    public String email;
    public int age;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.id.toString();
        this.name = user.name;
        this.email = user.email;
        this.age = user.age;
    }
}
