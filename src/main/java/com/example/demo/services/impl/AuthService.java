package com.example.demo.services.impl;

import com.example.demo.mappers.RegisterReqMapper;
import com.example.demo.model.dto.RegisterReqDto;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

  // private final UserService userService;
  private final RegisterReqMapper registerReqMapper;
  private final UserRepository userRepository;

  @Override
  public UserDetails register(RegisterReqDto userDto) {
    UserEntity userEntity = registerReqMapper.toEntity(userDto);

    System.out.println("Registering user: " + userEntity);
    System.out.println(userRepository.save(userEntity));
    return null;
  }
}
