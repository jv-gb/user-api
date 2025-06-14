package com.jv.user_service.controller;

import com.jv.user_service.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.jv.user_service.services.UserServices.usuarios;

@RestController
public class UserController {
    @GetMapping("/")
    public String getMensagem() {
        return "Está funcionando!";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUserFiltro(@PathVariable String cpf) {
        for (UserDTO userFilter : usuarios) {
            if (userFilter.getCpf().equals(cpf)) {
                return userFilter;
            }

        }
        return null;
    }
}
