package com.exam.services;

import com.exam.entites.User;
import com.exam.entites.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by Username
    public User getUserByUsername(String name);

    //delete user
    public void deleteUser(Long userId);
}
