package com.challenge.inventory.domain.usecase;

import com.challenge.inventory.domain.spi.UserPersistencePort;
import com.challenge.inventory.domain.api.UserServicePort;
import com.challenge.inventory.domain.model.User;
import java.util.List;
import java.util.UUID;

public class UserUseCase implements UserServicePort{
    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User createUser(User user) {
        // Business validation
        if (userPersistencePort.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists: " + user.getUsername());
        }
        return userPersistencePort.save(user);
    }

    @Override
    public User getUserById(UUID id) {
        return userPersistencePort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    @Override
    public User getUserByUsername(String username) {
        return userPersistencePort.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
    }

    @Override
    public List<User> getAllUsers() {
        return userPersistencePort.findAll();
    }

    @Override
    public User updateUser(UUID id, String firstName, String lastName) {
        User user = getUserById(id);
        user.updateProfile(firstName, lastName);
        return userPersistencePort.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        if (!userPersistencePort.findById(id).isPresent()) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
        userPersistencePort.deleteById(id);
    }
}

