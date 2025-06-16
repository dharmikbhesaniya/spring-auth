package com.example.demo.config.jpa;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Implementation of AuditorAware to provide current user information for JPA auditing. This
 * component automatically captures the currently authenticated user for audit fields.
 */
@Component("auditorProvider")
public class AuditorAwareImpl implements AuditorAware<String> {

  private static final Logger logger = LoggerFactory.getLogger(AuditorAwareImpl.class);
  private static final String SYSTEM_USER = "SYSTEM";
  private static final String ANONYMOUS_USER = "ANONYMOUS";

  /**
   * Returns the current auditor (user) for audit logging.
   *
   * @return Optional containing the current user's identifier, or SYSTEM/ANONYMOUS as fallback
   */
  @Override
  public Optional<String> getCurrentAuditor() {
    try {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

      // Check if the user is authenticated
      if (authentication == null || !authentication.isAuthenticated()) {
        logger.debug("No authenticated user found, using ANONYMOUS");
        return Optional.of(ANONYMOUS_USER);
      }

      // Handle anonymous authentication
      if ("anonymousUser".equals(authentication.getName())) {
        logger.debug("Anonymous user detected, using ANONYMOUS");
        return Optional.of(ANONYMOUS_USER);
      }

      String currentUser = authentication.getName();

      // Validate and sanitize the username
      if (currentUser == null || currentUser.trim().isEmpty()) {
        logger.warn("Authentication name is null or empty, falling back to SYSTEM");
        return Optional.of(SYSTEM_USER);
      }

      // Truncate username if too long (adjust length as per your DB schema)
      if (currentUser.length() > 50) {
        currentUser = currentUser.substring(0, 50);
        logger.warn("Username truncated to 50 characters: {}", currentUser);
      }

      logger.debug("Current auditor: {}", currentUser);
      return Optional.of(currentUser);

    } catch (Exception e) {
      logger.error("Error retrieving current auditor, falling back to SYSTEM", e);
      return Optional.of(SYSTEM_USER);
    }
  }
}
