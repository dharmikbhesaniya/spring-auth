package com.example.demo.controller;

import com.example.demo.model.dto.RegisterReqDto;
import com.example.demo.services.impl.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authenticationService;

  //    Add return type properly
  @PostMapping("/register")
  public void login(@Valid @RequestBody RegisterReqDto authenticationRequest) {
    UserDetails userDetails = authenticationService.register(authenticationRequest);
  }
}
