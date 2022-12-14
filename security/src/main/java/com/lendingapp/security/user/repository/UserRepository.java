package com.lendingapp.security.user.repository;

import com.lendingapp.security.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserDetails_Username(String username);
}
