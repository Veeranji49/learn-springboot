package com.example.repository;

import com.example.dto.UserDTO;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // masked sensitive data
    @Query("SELECT new com.example.dto.UserDTO(u.id, u.username, u.email, " +
            "CASE WHEN u.sensitiveData IS NULL THEN NULL " +
            "ELSE CONCAT(SUBSTRING(u.sensitiveData, 1, 2), 'xxxxx') END) " +
            "FROM User u")
    List<UserDTO> findAllWithMaskedData();

    // specific user by ID with masked sensitive data
    @Query("SELECT new com.example.dto.UserDTO(u.id, u.username, u.email, " +
            "CASE WHEN u.sensitiveData IS NULL THEN NULL " +
            "ELSE CONCAT(SUBSTRING(u.sensitiveData, 1, 2), 'xxxxx') END) " +
            "FROM User u WHERE u.id = :id")
    UserDTO findByIdWithMaskedData(@Param("id") Long id);

    //  find users without masking
    @Query("SELECT new com.example.dto.UserDTO(u.id, u.username, u.email, u.sensitiveData) " +
            "FROM User u")
    List<UserDTO> findAllWithoutMasking();

    @Query("SELECT new com.example.dto.UserDTO(u.id, u.username, u.email, u.sensitiveData) " +
            "FROM User u WHERE u.id = :id")
    UserDTO findByIdWithoutMasking(@Param("id") Long id);
}