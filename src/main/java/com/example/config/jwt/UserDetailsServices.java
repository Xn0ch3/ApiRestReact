package com.example.config.jwt;

import com.example.models.Users;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override //Aca sobreescribiremos este metodo para que sea como nosotros queramos
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(username); //Se le pasa un email y devuelve un client

        if (user == null){
            throw new UsernameNotFoundException(username);
        }

        User.UserBuilder builder = User.withUsername(username); // Fully qualify the Spring Security Client
        builder.password(user.getPassword()); // Use the custom client’s password
        builder.roles("CLIENT"); // Assign role

        return builder.build();
    }
}
