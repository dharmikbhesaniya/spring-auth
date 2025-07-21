package com.example.demo.services;

import com.example.demo.model.dto.RegisterReqDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface IAuthService {

    UserDetails register( RegisterReqDto userDto);
//    UserDetails authenticate(String email, String password);
//    String generateToken(UserDetails userDetails);
//    UserDetails validateToken(String token);
}
