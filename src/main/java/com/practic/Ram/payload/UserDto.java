package com.practic.Ram.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

public class UserDto {

    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min =3,max=50,message = "Name should be contain at least 3 character and maximum 50 character")
    private String name;

    @NotNull(message = "username should not be null")
    @Size(min=3,max = 40, message = "username must be at least 3 character maximum 40 character")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "username must be alphanumeric without spaces or special characters")
    private String username;

    @NotNull
    @Size(min=6,max=12, message = "password must be al least 6 character and maximum 12 character")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "password must me alphanumeric without spaces")
    private String password;

    @NotBlank(message = "email cannot be null")
    @Email(message = "email should be in proper format")
//    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
//            message = "Invalid email format")
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
