package com.henrique.projeto.mvc.controller;

import com.henrique.projeto.mvc.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AutorController {

    private List<Autor> autores = new ArrayList<>();

    @PostMapping({"/autores", "/autor"})
    public String adicionarAutor(@ModelAttribute Autor autor) {
        autores.add(autor);
        return "redirect:/autores";
    }
}
