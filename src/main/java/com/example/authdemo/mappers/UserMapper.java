package com.example.authdemo.mappers;

import com.example.authdemo.dtos.auth.RegisterDTO;
import com.example.authdemo.dtos.users.CreateUserDTO;
import com.example.authdemo.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toUser(CreateUserDTO createUserDTO);
}
