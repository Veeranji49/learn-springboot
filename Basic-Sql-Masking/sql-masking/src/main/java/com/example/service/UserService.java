package com.example.service;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAllWithMaskedData();
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setSensitiveData(userDTO.getSensitiveData());
        User savedUser = userRepository.save(user);
        return userRepository.findByIdWithMaskedData(savedUser.getId());
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findByIdWithMaskedData(id);
    }

    public List<UserDTO> findAllwithoutmasking(){
        return userRepository.findAllWithoutMasking();
    }

    public UserDTO findByIdWithoutMasking(Long id) {
        return userRepository.findByIdWithMaskedData(id);
    }
}