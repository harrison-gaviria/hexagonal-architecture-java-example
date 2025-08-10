package com.challenge.inventory.application.mapper.response;

import com.challenge.inventory.application.dto.response.UserResponse;
import com.challenge.inventory.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {

    @Mapping(source = "lastName", target = "lastname")
    UserResponse toResponse(User user);

    List<UserResponse> toResponses(List<User> users);
}