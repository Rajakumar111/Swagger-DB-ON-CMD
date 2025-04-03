package com.practic.Ram.repository;


import com.practic.Ram.entity.BusUser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<BusUser, Long> {
    Optional<BusUser> findByName(String name);
    Optional<BusUser> findByUsername(String username);
}
