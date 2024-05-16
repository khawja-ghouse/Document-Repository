package com.skg.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skg.springdemo.model.Chit;

public interface ChitRepository extends JpaRepository<Chit, Long> {

}
