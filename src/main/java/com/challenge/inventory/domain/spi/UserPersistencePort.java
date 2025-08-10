package com.challenge.inventory.domain.spi;

import com.challenge.inventory.domain.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserPersistencePort {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    boolean existsByUsername(String username);
    void deleteById(UUID id);
}
