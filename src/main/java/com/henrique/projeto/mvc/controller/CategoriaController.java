package com.henrique.projeto.mvc.controller;

import com.henrique.projeto.mvc.model.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoriaController {

    private List<Categoria> categorias = new ArrayList<>();

    @PostMapping({"/categorias", "/categoria"})
    public String adicionarCategoria(@ModelAttribute Categoria categoria) {
        categorias.add(categoria);
        return "redirect:/categorias";
    }
}
