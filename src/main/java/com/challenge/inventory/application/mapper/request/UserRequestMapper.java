package com.challenge.inventory.application.mapper.request;

import com.challenge.inventory.application.dto.request.UserRequest;
import com.challenge.inventory.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    User toDomain(UserRequest user);
    List<User> toDomains(List<UserRequest> users);
}