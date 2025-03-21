package com.practic.Ram.controller;

import com.practic.Ram.entity.User;
import com.practic.Ram.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saved = userService.createUser(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping("/getUserByUsername/{name}")
    public ResponseEntity<Optional<User>> getByName(@PathVariable("name") String nam){
        Optional<User> byName = userService.getByName(nam);
        return new ResponseEntity<>(byName,HttpStatus.OK);
    }
    @DeleteMapping("/deleteByUsername/{id}")
    public ResponseEntity<String> deleteByName(@PathVariable Long id){
        userService.deleteById(id);
        return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
    }
    @PutMapping("/updateById/{id}")
   public ResponseEntity<User> updateById(@PathVariable Long id,@RequestBody User user){
    User user1 = userService.updateById(id, user);
    return new ResponseEntity<>(user1,HttpStatus.OK);
   }

   @PatchMapping("/partiallyUpdate/{id}")
   public ResponseEntity<User> partiallyUpdate(@PathVariable Long id,@RequestBody User user){
       User user1 = userService.partiallyUpdate(id, user);
       return new ResponseEntity<>(user1,HttpStatus.OK);
    }


}
