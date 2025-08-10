package com.challenge.inventory.infrastructure.adapters.jpa;

import com.challenge.inventory.domain.model.User;
import com.challenge.inventory.domain.spi.UserPersistencePort;
import com.challenge.inventory.infrastructure.adapters.jpa.entity.UserEntity;
import com.challenge.inventory.infrastructure.adapters.jpa.mapper.UserEntityMapper;
import com.challenge.inventory.infrastructure.adapters.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserJpaAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        UserEntity savedEntity = userRepository.save(userEntity);
        return userEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id)
                .map(userEntityMapper::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userEntityMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> entities = userRepository.findAll();
        return userEntityMapper.toDomains(entities);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}