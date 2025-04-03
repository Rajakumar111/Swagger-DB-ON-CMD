package com.practic.Ram.service;

import com.practic.Ram.payload.LoginDto;
import com.practic.Ram.payload.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //Create
    public UserDto createUser(UserDto dto) ;

    //GetByName
    Optional<UserDto>  getByName(String name);


//DeleteById
  public void deleteById(Long id);


//UpdateById
   public UserDto updateById(Long id, UserDto dto);


//Patch
    public UserDto partiallyUpdate(Long id,UserDto dto);

//pagination

    public List<UserDto> getAll(int pageNo, int pageSize, String sortBy, String sortDirection);


    //GetById
    UserDto getById(long id);

    String verifyUser(LoginDto dto);
}
