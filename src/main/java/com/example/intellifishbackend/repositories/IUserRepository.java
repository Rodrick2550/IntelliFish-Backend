package com.example.intellifishbackend.repositories;

import com.example.intellifishbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
        Optional<User> findByEmail(String email);

        Boolean existsByCode(String code);
        Boolean existsByEmail(String email);
}
