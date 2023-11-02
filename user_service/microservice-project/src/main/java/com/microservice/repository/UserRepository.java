package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
