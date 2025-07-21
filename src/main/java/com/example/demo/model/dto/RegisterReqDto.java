package com.example.demo.model.dto;

import com.example.demo.common.annotations.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterReqDto {

  @NotBlank(message = "First Name is required")
  @Size(min = 2, max = 50, message = "First Name must be between 2 and 50 characters")
  private String firstName;

  @NotBlank(message = "Last Name is required")
  @Size(min = 2, max = 50, message = "Last Name must be between 2 and 50 characters")
  private String lastName;

  @NotBlank(message = "Email is required")
  @Email(message = "Invalid email format")
  private String email;

  @NotBlank(message = "Password is required")
  @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
  @ValidPassword // Assuming you have a custom password validation annotation
  private String password;

  @NotBlank(message = "Phone number is required")
  @Pattern(regexp = "\\d{6,15}", message = "Phone number must be between 6 and 15 digits")
  private String phoneNumber;

  @NotBlank(message = "Country code is required")
  @Pattern(
      regexp = "\\+\\d{1,4}",
      message = "Country code must start with '+' followed by 1 to 4 digits")
  private String phoneNumberCountryCode;

//  @NotBlank(message = "Date of Birth is required")
//  @Pattern(
//      regexp = "^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/\\d{4}$",
//      message = "Date of Birth must be in dd/MM/yyyy format")
//  private String dateOfBirth;
}
