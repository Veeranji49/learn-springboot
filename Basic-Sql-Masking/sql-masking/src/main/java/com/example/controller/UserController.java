package com.example.controller;

import com.example.dto.UserDTO;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value="/without-masking")
    public List<UserDTO> getUsersWithoutMasking() {
        return userService.findAllwithoutmasking();
    }

    @GetMapping(value="/without-masking/{id}")
    public UserDTO getUserWithoutMasking(@PathVariable Long id) {
        return userService.findByIdWithoutMasking(id);
    }
}