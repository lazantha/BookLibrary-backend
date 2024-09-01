package com.laza.BookLibrary.Service;

import com.laza.BookLibrary.Dto.LoginDto;
import com.laza.BookLibrary.Dto.RegisterDto;
import com.laza.BookLibrary.Entity.User;
import com.laza.BookLibrary.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User authenticateUser(LoginDto loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername());
        if (user != null && passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return user;
        }
        throw new RuntimeException("Invalid username or password");
    }

    public User registerUser(RegisterDto registerDTO) {
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());
        // Set other fields and default roles if necessary
        return userRepository.save(user);
    }
}
