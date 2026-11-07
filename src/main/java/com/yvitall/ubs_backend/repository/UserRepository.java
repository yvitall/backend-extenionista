package com.yvitall.ubs_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yvitall.ubs_backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}