package com.example.authdemo.services.auth;

import com.example.authdemo.dtos.auth.AuthResponseDTO;
import com.example.authdemo.dtos.auth.LoginDTO;
import com.example.authdemo.dtos.auth.RegisterDTO;
import com.example.authdemo.mappers.AuthMapper;
import com.example.authdemo.services.jwt.JwtService;
import com.example.authdemo.services.users.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final AuthMapper authMapper;


    public AuthResponseDTO login(LoginDTO dto) {
        Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );
        return AuthResponseDTO.builder().token(jwtService.generateToken(dto.getEmail())).build();
    }

    public AuthResponseDTO register(RegisterDTO dto) {
        var user = userService.createUser(authMapper.getCreateUserDTO(dto));

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );
        return AuthResponseDTO.builder().token(jwtService.generateToken(user.getEmail())).build();
    }
}
