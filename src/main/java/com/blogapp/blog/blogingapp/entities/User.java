package com.blogapp.blog.blogingapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="user_name", nullable = false, length = 100)
    private String name;
    @Column(name="email", nullable = false, length = 100)
    private String email;
    @Column(name="password", nullable = false, length = 100)
    private String password;

    private String about;

}
