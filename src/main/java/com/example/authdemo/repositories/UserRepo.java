package com.example.authdemo.repositories;

import com.example.authdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String username);

    void deleteByIdAndEmail(Long id, String email);
}
