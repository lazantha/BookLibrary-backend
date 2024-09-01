package com.laza.BookLibrary.Controller;

import com.laza.BookLibrary.Dto.RegisterDto;
import com.laza.BookLibrary.Dto.LoginDto;
import com.laza.BookLibrary.Dto.ApiResponse;
import com.laza.BookLibrary.Entity.User;
import com.laza.BookLibrary.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<User>> registerUser(@RequestBody RegisterDto registerDTO) {
        try {
            User registeredUser = userService.registerUser(registerDTO);
            ApiResponse<User> response = new ApiResponse<>("success", "User registered successfully", registeredUser);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<User> response = new ApiResponse<>("error", "Registration failed: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<User>> loginUser(@RequestBody LoginDto loginDTO) {
        try {
            User authenticatedUser = userService.authenticateUser(loginDTO);
            ApiResponse<User> response = new ApiResponse<>("success", "User logged in successfully", authenticatedUser);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<User> response = new ApiResponse<>("error", "Login failed: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
