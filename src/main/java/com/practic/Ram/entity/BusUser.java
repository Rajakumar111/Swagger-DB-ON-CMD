package com.practic.Ram.entity;

import jakarta.persistence.*;

@Entity
public class BusUser {

    @GeneratedValue(strategy = GenerationType.IDENTITY)   //primary key
    @Id
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;


    //candidate key - due to it is same as primary key, all the characteristic of primary key contains by candidate key.
    @Column(name="username",nullable = false,unique = true)
    private String username;

    @Column(name="password",nullable = false)
    private String password;


    //candidate key - due to it is same as primary key, all the characteristic of primary key contains by candidate key.
    @Column(name="email",nullable = false,unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
