package com.practic.Ram.controller;

import com.practic.Ram.payload.UserDto;
import com.practic.Ram.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
   private final UserService userService; //= new UserServiceImpl();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto dto) {
        UserDto saved = userService.createUser(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);

    }
    @GetMapping("/getUserByUsername/{name}")
    public ResponseEntity<Optional<UserDto>> getByName(@PathVariable("name") String name){
        Optional<UserDto> byName = userService.getByName(name);
        return new ResponseEntity<>(byName,HttpStatus.OK);
    }
    // Need to Learn Concept of Idempotent - Home Work
    @DeleteMapping("/deleteByUsername/{id}")
    public ResponseEntity<String> deleteByName(@PathVariable Long id){
        userService.deleteById(id);
        return new ResponseEntity<>("BusUser Deleted Successfully",HttpStatus.OK);
    }

    //GetAll
@GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAll(

            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue ="asc" ) String sortDirection
){
        List<UserDto> all = userService.getAll(pageNo,pageSize,sortBy,sortDirection);
        return new ResponseEntity<>(all,HttpStatus.OK);
    }


    @PutMapping("/updateById/{id}")
   public ResponseEntity<UserDto> updateById(@PathVariable Long id,@RequestBody UserDto dto){
    UserDto user1Dto1 = userService.updateById(id, dto);
    return new ResponseEntity<>(user1Dto1,HttpStatus.OK);
   }

   @PatchMapping("/partiallyUpdate/{id}")
   public ResponseEntity<UserDto> partiallyUpdate(@PathVariable Long id,@RequestBody UserDto user){
       UserDto user1 = userService.partiallyUpdate(id, user);
       return new ResponseEntity<>(user1,HttpStatus.OK);
    }


}
