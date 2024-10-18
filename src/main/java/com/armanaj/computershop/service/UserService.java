package com.armanaj.computershop.service;

import com.armanaj.computershop.model.User;
import com.armanaj.computershop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    public boolean checkIfOldPasswordMatches(Integer id, String oldPassword) {
        User user = getUserById(id);
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    public void changeUserPassword(Integer id, String password) {
        User user = getUserById(id);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}
