package com.blogapp.blog.blogingapp.services;

import com.blogapp.blog.blogingapp.entities.User;
import com.blogapp.blog.blogingapp.payloads.UserDto;

import java.util.List;

public interface UserService {

   UserDto createUser(UserDto user);
   UserDto updateUser(UserDto user,Integer userId);
   UserDto getUserById(Integer userId);
   List<UserDto> getAllUser();
   void deleteUser(Integer userId);
}
