package com.example.Controller;

import com.example.Entity.User;
import com.example.Service.JwtService;
import com.example.Service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/auth")
@Tag(name="User Controller")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    //Endpoint to add a new user
    @PostMapping(value="/addUser")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    //Endpoint for user login and token generation
    @PostMapping(value="/login")
    public String loginUser(@RequestBody User user){

        //Authenticate the user
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));

        //if authentication successful  and generate or return a Token
        if (authenticate.isAuthenticated()){
            return jwtService.generateToken(user.getUserName());
        }
        else{
            throw new UsernameNotFoundException("Invalid User request");
        }
    }
}
