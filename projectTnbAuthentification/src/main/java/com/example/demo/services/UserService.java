package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserRegistrationRequest registrationRequest) {
        // Check if the username is already taken
        if (userRepository.findByUsername(registrationRequest.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        // Create a new user entity
        User newUser = new User();
        newUser.setUsername(registrationRequest.getUsername());
        newUser.setName(registrationRequest.getName());
        newUser.setLastname(registrationRequest.getLastname());
        newUser.setDateOfBirth(registrationRequest.getDateOfBirth());
        newUser.setCin(registrationRequest.getCin());
        newUser.setTel(registrationRequest.getTel());
        newUser.setAddress(registrationRequest.getAddress());
        newUser.setPhoto(registrationRequest.getPhoto());

        // Encode the password before storing it
        String encodedPassword = passwordEncoder.encode(registrationRequest.getPassword());
        newUser.setPassword(encodedPassword);

        // Save the user to the database
        userRepository.save(newUser);
    }
}
