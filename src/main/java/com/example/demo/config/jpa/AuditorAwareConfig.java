package com.example.demo.config.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class AuditorAwareConfig{

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            // For now, use a static user. Integrate with SecurityContext for real auth.
            return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
        };
    }
}
