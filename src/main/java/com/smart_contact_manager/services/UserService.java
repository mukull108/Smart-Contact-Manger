package com.smart_contact_manager.services;

import java.util.List;
import java.util.Optional;

import com.smart_contact_manager.entities.User;

public interface UserService {

    //get user by id
    Optional<User> findUserById(String id);

    //create user or save user
    User saveUser(User user);

    //delete user
    void deleteUserById(String id);

    //update user
    Optional<User> updateUser(User user);

    //check if exists
    boolean isUserExist(String userId);
    boolean isUserExistByUserName(String email);

    //get all users
    Optional<List<User>> getAllUser();


} 
