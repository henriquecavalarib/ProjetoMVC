package com.henrique.projeto.mvc.controller;

import com.henrique.projeto.mvc.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping({"/usuarios", "/usuario"})
    public String adicionarUsuario(@ModelAttribute Usuario usuario) {
        usuarios.add(usuario);
        return "redirect:/usuarios";
    }
}
