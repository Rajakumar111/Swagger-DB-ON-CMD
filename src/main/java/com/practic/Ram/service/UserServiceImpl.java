package com.practic.Ram.service;

import com.practic.Ram.entity.User;
import com.practic.Ram.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo repo;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }


    //create
    @Override
    public User createUser(User user) {
        User saved = repo.save(user);
        return saved;
    }

    //GetByName
    @Override
    public Optional<User> getByName(String nam) {
        Optional<User> byName = repo.findByName(nam);
        if (byName.isPresent()) {
            User user = byName.get();
            return Optional.of(user);
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
    public User updateById(Long id, User user) {
        Optional<User> byId = repo.findById(id);
        User exitingUser = byId.get();
//        exitingUser.setName(user.getName());
//        exitingUser.setEmail(user.getEmail());
//        exitingUser.setPassword(user.getPassword());
//        exitingUser.setUsername(user.getUsername());
        modelMapper.map(user, exitingUser);
      exitingUser.setId(id);
        User save1 = repo.save(exitingUser);
        return save1;
    }

    //patch
    @Override
    public User partiallyUpdate(Long id,User user) {
        Optional<User> byId = repo.findById(id);
        User existingUser = byId.get();
//        if (user.getName()!=null){
//            existingUser.setName(user.getName());
//        }
//        if (user.getEmail()!=null){
//            existingUser.setEmail(user.getEmail());
//        }
//        if (user.getPassword()!=null){
//            existingUser.setPassword(user.getPassword());
//        }
//        if (user.getUsername()!=null){
//            existingUser.setUsername(user.getUsername());
//        }

        modelMapper.getConfiguration()
                .setSkipNullEnabled(true)   // ⿡ Skip null values
                .setFieldMatchingEnabled(true) ; // ⿢ Match fields by name
//                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);  // ⿣ Access private fields

        modelMapper.map(user,existingUser);
//        existingUser.setId(id);
        User save = repo.save(existingUser);
        return save;
    }

}