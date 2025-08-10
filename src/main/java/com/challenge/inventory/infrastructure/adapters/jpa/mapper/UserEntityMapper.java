package com.challenge.inventory.infrastructure.adapters.jpa.mapper;

import com.challenge.inventory.domain.model.User;
import com.challenge.inventory.infrastructure.adapters.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    User toDomain(UserEntity userEntity);
    UserEntity toEntity(User user);
    List<User> toDomains(List<UserEntity> userEntities);
    List<UserEntity> toEntities(List<User> users);
}