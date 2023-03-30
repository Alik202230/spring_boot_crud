package com.javadev.crud.spring.boot.service;

import com.javadev.crud.spring.boot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceImplementation {
  User saveUser(User user);
  Optional<User> getUserById(Long id);
  List<User> getUserByName(String name);
  String deleteUserById(Long id);
}
