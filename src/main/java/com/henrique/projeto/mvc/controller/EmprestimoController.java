package com.henrique.projeto.mvc.controller;

import com.henrique.projeto.mvc.model.Emprestimo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmprestimoController {

    private List<Emprestimo> emprestimos = new ArrayList<>();

    @PostMapping({"/emprestimos", "/emprestimo"})
    public String adicionarEmprestimo(@ModelAttribute Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        return "redirect:/emprestimos";
    }
}
