package com.example.authdemo.mappers;

import com.example.authdemo.dtos.auth.RegisterDTO;
import com.example.authdemo.dtos.users.CreateUserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    CreateUserDTO getCreateUserDTO(RegisterDTO registerDTO);
}
