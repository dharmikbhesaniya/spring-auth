package com.example.demo.utils.enums;

/**
 * Defines the origin/source by which a user account was created in the system.

 * NORMAL   - User registered by themselves via standard registration (e.g., email/password)
 * ADMIN - User created manually by an administrator (e.g., staff added via the admin panel)
 * SYSTEM - User created automatically by the system (e.g., for background processes, service accounts)
 * GOOGLE   - User account created via Google OAuth2 login
 * GITHUB   - User account created via GitHub OAuth2 login
 * FACEBOOK - User account created via Facebook OAuth2 login
 * APPLE    - User account created via Apple OAuth2 login
 */

public enum AuthProviderEnum {
    NORMAL,
    ADMIN,
    SYSTEM,
    GOOGLE,
    GITHUB,
    FACEBOOK,
    APPLE
}
