package com.example.myproject.service;

import org.springframework.stereotype.Service;

import com.example.myproject.domain.Role;
import com.example.myproject.domain.User;
import com.example.myproject.repository.RoleRepository;
import com.example.myproject.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  public UserService(UserRepository userRepository, RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
  }

  public List<User> getAllUser() {
    return this.userRepository.findAll();
  }

  public List<User> getAllUserByEmail(String email) {
    return this.userRepository.findByEmail(email);
  }

  public String handleHello() {
    return "Hello Server";
  }

  public User handleSaveUser(User user) {
    User pun = this.userRepository.save(user);
    // System.out.println(pun);
    return pun;
  }

  public User getByUserId(long id) {
    return this.userRepository.findById(id);
  }

  // Delete User
  public void deleteByUser(long id) {
    this.userRepository.deleteById(id);
  }

  public Role getRoleByName(String name) {
    return this.roleRepository.findByName(name);
  }
}