package com.blogapp.blog.blogingapp.serviceImpl;

import com.blogapp.blog.blogingapp.entities.User;
import com.blogapp.blog.blogingapp.payloads.UserDto;
import com.blogapp.blog.blogingapp.repositories.UserRepositories;
import com.blogapp.blog.blogingapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import com.blogapp.blog.blogingapp.exceptions.*;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

     @Autowired
     private UserRepositories userRepositories;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=dtoToUser(userDto);
        User savedUser= userRepositories.save(user);
        return userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=userRepositories.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updateUser=userRepositories.save(user);
        UserDto userDto1=userToDto(updateUser);

        return userDto1 ;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user=userRepositories.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        return userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users =userRepositories.findAll();
        List<UserDto> userDtos=users.stream().map(user -> userToDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=userRepositories.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        userRepositories.delete(user);
    }

    private User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }
    private UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
