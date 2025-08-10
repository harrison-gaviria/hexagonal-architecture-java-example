package com.challenge.inventory.application.handler;

import com.challenge.inventory.application.dto.request.UserRequest;
import com.challenge.inventory.application.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserHandler {
    UserResponse createUser(UserRequest user);
    UserResponse getUserById(UUID id);
    UserResponse getUserByUsername(String username);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(UUID id, String firstName, String lastName);
    void deleteUser(UUID id);
}