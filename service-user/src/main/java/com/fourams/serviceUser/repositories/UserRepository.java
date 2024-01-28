package com.fourams.serviceUser.repositories;

import com.fourams.serviceUser.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer> {
    public Optional<User> findUserByEmailAndPassword(String email, String password);
    public User findUserByEmail(String email);
}

