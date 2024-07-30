package com.example.dto;

public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String sensitiveData;


    public UserDTO(){}

    public UserDTO(Long id, String username, String email, String sensitiveData) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.sensitiveData = sensitiveData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSensitiveData() {
        return sensitiveData;
    }

    public void setSensitiveData(String sensitiveData) {
        this.sensitiveData = sensitiveData;
    }
}