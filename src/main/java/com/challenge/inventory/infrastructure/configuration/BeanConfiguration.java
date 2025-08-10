package com.challenge.inventory.infrastructure.configuration;

import com.challenge.inventory.domain.api.UserServicePort;
import com.challenge.inventory.domain.spi.UserPersistencePort;
import com.challenge.inventory.domain.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserServicePort userServicePort(UserPersistencePort userPersistencePort) {
        return new UserUseCase(userPersistencePort);
    }
}