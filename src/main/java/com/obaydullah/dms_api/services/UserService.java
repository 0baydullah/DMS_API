package com.obaydullah.dms_api.services;

import com.obaydullah.dms_api.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> allUsers();
    User saveUser(User user);
    User getUserById(Long id);
    User updateUser(User user, Long id);
    User deleteUser(Long id);
}
