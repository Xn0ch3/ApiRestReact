package com.example.controllers;

import com.example.dtos.userDtos.RegisterDTO;
import com.example.dtos.userDtos.UserDTO;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUserDTO();
    }

    @PostMapping("/register")
    public ResponseEntity<String> userRegister(@RequestBody RegisterDTO registerDTO){
        return userService.register(registerDTO);
    }
}
