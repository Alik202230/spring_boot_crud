package com.javadev.crud.spring.boot.service;

import com.javadev.crud.spring.boot.model.User;
import com.javadev.crud.spring.boot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceImplementation {
  private final UserRepository userRepository;
  public UserService (UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public Optional<User> getUserById(Long id) {
    List<User> users = userRepository.findAll();
    return Optional.ofNullable(users.stream()
      .filter(user -> user.getId().equals(id))
      .findFirst()
      .orElseThrow(() -> new RuntimeException("User not found")));
  }

  @Override
  public List<User> getUserByName(String name) {
    List<User> users = userRepository.findAll()
      .stream()
      .filter(user -> user.getName().equals(name))
      .findFirst()
      .stream().collect(Collectors.toList());
    return users;
  }

  @Override
  public String deleteUserById(Long id) {
    Optional<User> deleteUser = userRepository.findAll()
      .stream()
      .filter(user -> user.getId().equals(id))
      .findFirst();
    deleteUser.ifPresent(userRepository::delete);
    return "User with the id of  " + id + " has been deleted successfully!";
  }
}
