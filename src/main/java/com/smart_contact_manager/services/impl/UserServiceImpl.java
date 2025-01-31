package com.smart_contact_manager.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_contact_manager.entities.User;
import com.smart_contact_manager.helper.ResourceNotFoundException;
import com.smart_contact_manager.repositories.UserRepository;
import com.smart_contact_manager.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public User saveUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        //encode the password also
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public void deleteUserById(String id) {
        User user2 = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userRepository.delete(user2);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepository.findById(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // update user2 from user
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setContacts(user.getContacts());
        user2.setAbout(user.getAbout());
        user2.setPassword(user.getPassword());
        user2.setProfilePic(user.getProfilePic());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setEnabled(user.isEnabled());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        User savedUser = userRepository.save(user2);
        return Optional.ofNullable(savedUser);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user!=null;
    }

    @Override
    public boolean isUserExistByUserName(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        return user!=null;
    }

    @Override
    public Optional<List<User>> getAllUser() {
        List<User> allUser = userRepository.findAll();
        return Optional.ofNullable(allUser);
    }

}
