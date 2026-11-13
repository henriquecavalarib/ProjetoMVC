package com.henrique.projeto.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("nomeSistema", "Sistema de Gestão de Biblioteca");
        model.addAttribute("mensagemBoasVindas", "Bem-vindo ao sistema de controle de acervo e empréstimos!");
        return "index";
    }
}
