package com.practic.Ram.service;

import com.practic.Ram.entity.User;

import java.util.Optional;

public interface UserService {

    public User createUser(User user) ;

  Optional<User>  getByName(String nam);

  public void deleteById(Long id);

   public User updateById(Long id, User user);

    public User partiallyUpdate(Long id,User user);
}
