package com.example.authdemo.api;

import com.example.authdemo.dtos.auth.AuthResponseDTO;
import com.example.authdemo.dtos.auth.LoginDTO;
import com.example.authdemo.dtos.auth.RegisterDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/auth/")
@Tag(name = "Authentication")
@Transactional
public interface AuthAPI {

    @Operation(
            summary = "Login user",
            description = "Authenticates the user and returns a JWT token"
    )
    @PostMapping("/login")
    ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO);

    @Operation(
            summary = "Register user",
            description = "Registers & Authenticates the user and returns a JWT token"
    )
    @PostMapping("/register")
    ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterDTO registerDTO);


}
