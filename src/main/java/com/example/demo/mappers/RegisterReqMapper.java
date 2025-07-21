package com.example.demo.mappers;

import com.example.demo.model.dto.RegisterReqDto;
import com.example.demo.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegisterReqMapper {

  RegisterReqDto toDto(UserEntity user);
  UserEntity toEntity(RegisterReqDto userReq);
}
