package com.practic.Ram.service;

import com.practic.Ram.payload.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public UserDto createUser(UserDto dto) ;

  Optional<UserDto>  getByName(String name);

  public void deleteById(Long id);

   public UserDto updateById(Long id, UserDto dto);

    public UserDto partiallyUpdate(Long id,UserDto dto);

    public List<UserDto> getAll(int pageNo, int pageSize, String sortBy, String sortDirection);
}
