package com.example.services.implement;

import com.example.dtos.userDtos.RegisterDTO;
import com.example.dtos.userDtos.UserDTO;
import com.example.models.Users;
import com.example.repository.UserRepository;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(Users users) {
        userRepository.save(users);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDTO> getAllUserDTO() {
        return getAllUser().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> register(RegisterDTO registerDTO) {

        if(existsByEmail(registerDTO.getEmail())){
            return new ResponseEntity<>("Email already on use", HttpStatus.FORBIDDEN);
        }
        if(registerDTO.getName().isBlank()){
            return new ResponseEntity<>("El nombre no puede estar vacio",HttpStatus.FORBIDDEN);
        }
        if(registerDTO.getLastName().isBlank()){
            return new ResponseEntity<>("El apellido no puede estar vacio",HttpStatus.FORBIDDEN);
        }
        if(registerDTO.getEmail().isBlank()){
            return new ResponseEntity<>("El email no puede estar vacio",HttpStatus.FORBIDDEN);
        }
        if(registerDTO.getPassword().isBlank()){
            return new ResponseEntity<>("La contraseña no puede estar vacia",HttpStatus.FORBIDDEN);
        }

        Users users = new Users(registerDTO.getName(),registerDTO.getLastName(),registerDTO.getEmail(),passwordEncoder.encode(registerDTO.getPassword()));
        saveUser(users);

        return new ResponseEntity<>("Successfully registered users", HttpStatus.CREATED);
    }


}
