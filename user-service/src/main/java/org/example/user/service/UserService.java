package org.example.user.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.example.user.entity.User;

import java.util.List;

@ApplicationScoped
public class UserService {
    public List<User> getAllUsers() {
        return User.listAll();
    }

    public User getUserById(String id) {
        return User.findById(new ObjectId(id));
    }

    public void createUser(User user) {
        user.persist();
    }

    public void updateUser(String id, User updatedUser) {
        User user = User.findById(new ObjectId(id));
        if (user != null) {
            user.name = updatedUser.name;
            user.email = updatedUser.email;
            user.age = updatedUser.age;
            user.persistOrUpdate();
        }
    }

    public void deleteUser(String id) {
        User.deleteById(new ObjectId(id));
    }
}
