package com.skg.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skg.springdemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
