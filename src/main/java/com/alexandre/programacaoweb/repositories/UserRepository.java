package com.alexandre.programacaoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandre.programacaoweb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> { }
