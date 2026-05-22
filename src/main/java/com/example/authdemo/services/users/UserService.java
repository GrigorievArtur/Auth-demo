package com.example.authdemo.services.users;

import com.example.authdemo.dtos.auth.RegisterDTO;
import com.example.authdemo.entities.User;
import com.example.authdemo.mappers.UserMapper;
import com.example.authdemo.repositories.UserRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public User createUser(RegisterDTO dto) {
        var user = userMapper.toUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userRepo.save(user);
    }

    public void deleteUser(Long userId, UserDetails userDetails) {
        userRepo.deleteByIdAndEmail(userId, userDetails.getUsername());
    }

    @Override
    public UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
