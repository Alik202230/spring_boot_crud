package com.javadev.crud.spring.boot.controller;

import com.javadev.crud.spring.boot.model.User;
import com.javadev.crud.spring.boot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create")
  public User user(@RequestBody User user) {
    return userService.saveUser(user);
  }

  @GetMapping( "/{id}")
  public Optional<User> getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @GetMapping("/name/{name}")
  public List<User> getUserByName(@PathVariable String name) {
    return userService.getUserByName(name);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteUserById(@PathVariable Long id) {
    return userService.deleteUserById(id);
  }

}
