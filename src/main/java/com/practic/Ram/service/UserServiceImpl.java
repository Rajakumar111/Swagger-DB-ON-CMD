package com.practic.Ram.service;

import com.practic.Ram.entity.BusUser;
import com.practic.Ram.exception.ResourceNotFoundException;
import com.practic.Ram.payload.LoginDto;
import com.practic.Ram.payload.UserDto;
import com.practic.Ram.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo repo;//new ProxyClass();
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }


    //create
    @Override
    public UserDto createUser(UserDto dto) {

        
        BusUser map = modelMapper.map(dto, BusUser.class);
        String hashpw = BCrypt.hashpw(map.getPassword(), BCrypt.gensalt(5));
        map.setPassword(hashpw);
        System.out.println(hashpw);
        BusUser saved = repo.save(map);
        UserDto map1 = modelMapper.map(saved, UserDto.class);
        return map1;

    }
    //GetByName
    @Override
    public Optional<UserDto> getByName(String name) {
        Optional<BusUser> byName = repo.findByName(name);
        if (byName.isPresent()) {
            BusUser busUser = byName.get();
            UserDto dto = modelMapper.map(busUser, UserDto.class);
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }

    //DeleteById
    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);

    }

    //update
    @Override
    public UserDto updateById(Long id, UserDto dto) {
        Optional<BusUser> byId = repo.findById(id);
        BusUser exitingBusUser = byId.get();
//        exitingBusUser.setName(user.getName());
//        exitingBusUser.setEmail(user.getEmail());
//        exitingBusUser.setPassword(user.getPassword());
//        exitingBusUser.setUsername(user.getUsername());
        modelMapper.map(dto, exitingBusUser);
        exitingBusUser.setId(id);
        BusUser save1 = repo.save(exitingBusUser);
        UserDto dto1 = modelMapper.map(save1, UserDto.class);
        return dto1;
    }

    //patch
    @Override
    public UserDto partiallyUpdate(Long id,UserDto dto) {
        Optional<BusUser> byId = repo.findById(id);
        BusUser existingBusUser = byId.get();
//        if (user.getName()!=null){
//            existingBusUser.setName(user.getName());
//        }
//        if (user.getEmail()!=null){
//            existingBusUser.setEmail(user.getEmail());
//        }
//        if (user.getPassword()!=null){
//            existingBusUser.setPassword(user.getPassword());
//        }
//        if (user.getUsername()!=null){
//            existingBusUser.setUsername(user.getUsername());
//        }

        modelMapper.getConfiguration()   //set up the configuration for model mapper
                .setSkipNullEnabled(true)   // ⿡ Skip null values
                .setFieldMatchingEnabled(true) ; // ⿢ Match fields by name
//                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);  // ⿣ Access private fields

        modelMapper.map(dto, existingBusUser);  //user se data get karega or existing me set karega
//        existingBusUser.setId(id);
        BusUser save = repo.save(existingBusUser);  //repo yaha pe save karega
        UserDto dto2 = modelMapper.map(save, UserDto.class);
        return dto2;
    }

    @Override
    public List<UserDto> getAll(int pageNo, int pageSize, String sortBy, String sortDirection) {  //

        Sort sort = Sort.by(sortBy);

        if (sortDirection.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }

//        Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<BusUser> all = repo.findAll(pageRequest);
        List<UserDto> collect = all.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public UserDto getById(long id) {
        BusUser busUser = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("id is not present" + id));
        UserDto map = modelMapper.map(busUser, UserDto.class);
        return map;
    }

    @Override
    public String verifyUser(LoginDto dto) {
        Optional<BusUser> byUserName = repo.findByUsername(dto.getUsername());
        if(byUserName.isPresent()){
            BusUser busUser = byUserName.get();
            if(BCrypt.checkpw(dto.getPassword(), busUser.getPassword())){
                return "Login Successful";
            } else {
                return "cridentials Wrong Please Check Username or Password";
            }
        } else {
            return "User not found";
        }
    }
}