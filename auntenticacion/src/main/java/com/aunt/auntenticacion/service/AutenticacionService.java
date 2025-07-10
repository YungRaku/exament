package com.aunt.auntenticacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aunt.auntenticacion.model.User;
import com.aunt.auntenticacion.repository.UserRepository;

//Lo mismo, no se puede aplicar una nueva dependencia
//import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AutenticacionService {

    @Autowired
    private UserRepository userRepository;
    
    //@Autowired
    //private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers(){
        List<?> users = userRepository.findAll();
        return users.stream()
            .filter(User.class::isInstance)
            .map(User.class::cast)
            .toList();
    }


}
