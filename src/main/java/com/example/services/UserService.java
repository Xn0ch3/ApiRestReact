package com.example.services;

import com.example.dtos.userDtos.RegisterDTO;
import com.example.dtos.userDtos.UserDTO;
import com.example.models.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    Users findById (Long id);
    Users findByEmail(String email);
    void saveUser(Users users);
    boolean existsByEmail(String email);
    List<Users> getAllUser();
    List<UserDTO> getAllUserDTO();
    ResponseEntity<String> register(RegisterDTO registerDTO);
}
