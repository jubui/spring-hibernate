package com.example.dao;

import com.example.model.User;

import java.util.List;

public interface UserDAO {
  void save(User user);
  List<User> list();
  User getById(Long id);
  void update(User user);
  void delete(Long id);
}