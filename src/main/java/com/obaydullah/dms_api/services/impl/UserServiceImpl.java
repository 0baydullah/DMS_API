package com.obaydullah.dms_api.services.impl;

import com.obaydullah.dms_api.entities.User;
import com.obaydullah.dms_api.exceptions.ResourceNotFoundException;
import com.obaydullah.dms_api.repositories.UserRepository;
import com.obaydullah.dms_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","ID",id));
    }

    @Override
    public User updateUser(User user, Long id) {
        User userToUpdate = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","ID",id));
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setProfilePic(user.getProfilePic());
        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setSex(user.getSex());
        return userRepository.save(userToUpdate);

    }

    @Override
    public User deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
        return user;
    }
}
