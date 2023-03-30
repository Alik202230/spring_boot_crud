package com.javadev.crud.spring.boot.repository;

import com.javadev.crud.spring.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
