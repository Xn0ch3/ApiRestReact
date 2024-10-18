package com.example.dtos.userDtos;


import com.example.models.Users;
import com.example.models.enums.Rol;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Rol rol;

    //En los DTO para obtener listas se inicializa un constructor para el mapeo
    public UserDTO(Users user) {
        id = user.getId();
        name = user.getName();
        lastName = user.getLastName();
        email = user.getEmail();
        rol = user.getRol();
    }
}
