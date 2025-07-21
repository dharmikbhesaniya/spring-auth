package com.example.demo.model.entity;

import com.example.demo.model.entity.base.BaseEntity;
import com.example.demo.utils.enums.AuthProviderEnum;
import com.example.demo.utils.enums.OnboardingProcessStatusEnum;
import com.example.demo.utils.enums.UserRoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(
    name = "users_table",
    uniqueConstraints = {
      @UniqueConstraint(columnNames = {"email"}),
      @UniqueConstraint(columnNames = {"username"})
    })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity {

  //  add country code, address, etc. if needed

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(length = 20, nullable = false)
  private String phoneNumber;

  @Column(length = 20, nullable = false)
  private String phoneNumberCountryCode;

  @Column(unique = true, nullable = true)
  private String username;

  //  TODO: Add validation for date of birth (improve if needed as type)
  //  format should be dd/mm/yyyy
  @Column(name = "date_of_birth", nullable = true)
  private LocalDate dateOfBirth;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  @Builder.Default
  private UserRoleEnum role = UserRoleEnum.USER;

  @Builder.Default
  @Column(nullable = false)
  private Boolean isVerified = false;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  @Builder.Default
  private AuthProviderEnum provider = AuthProviderEnum.NORMAL;

  @Builder.Default
  @Column(nullable = false)
  private Integer loginAttempts = 0;

  @Column(name = "blocked_until")
  private LocalDateTime blockedUntil;

  @Column(nullable = false)
  private String password;

  @Column(name = "profile_picture_url", nullable = true)
  private String profilePictureUrl;

  //  TODO: Consider using a more secure way to store password history, such as hashing
  //  maximum 5 passwords not more then 5 index
//  @ElementCollection(fetch = FetchType.EAGER)
//  @CollectionTable(name = "user_password_history", joinColumns = @JoinColumn(name = "user_id"))
//  @Column(name = "password", nullable = false, length = 255)
//  private List<String> passwordHistory;

  @Column(name = "totp_secret", length = 32)
  @JsonIgnore
  private String totpSecret;

  @Column(name = "mpin", length = 255)
  @JsonIgnore
  private String mpin;

  @Column(name = "tpin", length = 255)
  @JsonIgnore
  private String tpin;

  @Builder.Default
  @Column(name = "two_factor_enabled", nullable = false)
  private Boolean twoFactorEnabled = false;

  @Builder.Default
  @Column(name = "is_suspended", nullable = false)
  private Boolean isSuspended = false;

  @Builder.Default
  @Column(name = "is_deactivated", nullable = false)
  private Boolean isDeactivated = false;

  @Enumerated(EnumType.STRING)
  @Column(name = "onboarding_process", length = 20)
  @Builder.Default
  private OnboardingProcessStatusEnum onboardingProcess = OnboardingProcessStatusEnum.PENDING;
}
