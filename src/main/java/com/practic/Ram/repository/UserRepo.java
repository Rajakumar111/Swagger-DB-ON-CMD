package com.practic.Ram.repository;

import com.practic.Ram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User , Long> {
    Optional<User> findByName(String name);
}
