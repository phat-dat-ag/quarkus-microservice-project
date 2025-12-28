package org.example.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank(message = "name should not be empty")
    private String name;

    @NotBlank(message = "email should not be empty")
    @Email(message = "email must be valid")
    private String email;

    @Min(value = 1, message = "age must be bigger than 1")
    private int age;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
