package com.challenge.inventory.domain.api;

import com.challenge.inventory.domain.model.User;
import java.util.List;
import java.util.UUID;

public interface UserServicePort {
    User createUser(User user);
    User getUserById(UUID id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    User updateUser(UUID id, String firstName, String lastName);
    void deleteUser(UUID id);
}
