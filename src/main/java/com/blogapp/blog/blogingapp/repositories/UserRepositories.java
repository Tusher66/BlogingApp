package com.blogapp.blog.blogingapp.repositories;

import com.blogapp.blog.blogingapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, Integer > {
}
