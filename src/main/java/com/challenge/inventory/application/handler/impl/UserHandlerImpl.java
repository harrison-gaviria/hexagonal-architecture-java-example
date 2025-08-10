package com.challenge.inventory.application.handler.impl;

import com.challenge.inventory.application.dto.request.UserRequest;
import com.challenge.inventory.application.dto.response.UserResponse;
import com.challenge.inventory.application.handler.UserHandler;
import com.challenge.inventory.application.mapper.request.UserRequestMapper;
import com.challenge.inventory.application.mapper.response.UserResponseMapper;
import com.challenge.inventory.domain.api.UserServicePort;
import com.challenge.inventory.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements UserHandler {

    private final UserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = userRequestMapper.toDomain(userRequest);
        User createdUser = userServicePort.createUser(user);
        return userResponseMapper.toResponse(createdUser);
    }

    @Override
    public UserResponse getUserById(UUID id) {
        User user = userServicePort.getUserById(id);
        return userResponseMapper.toResponse(user);
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        User user = userServicePort.getUserByUsername(username);
        return userResponseMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userServicePort.getAllUsers();
        return userResponseMapper.toResponses(users);
    }

    @Override
    public UserResponse updateUser(UUID id, String firstName, String lastName) {
        User updatedUser = userServicePort.updateUser(id, firstName, lastName);
        return userResponseMapper.toResponse(updatedUser);
    }

    @Override
    public void deleteUser(UUID id) {
        userServicePort.deleteUser(id);
    }
}