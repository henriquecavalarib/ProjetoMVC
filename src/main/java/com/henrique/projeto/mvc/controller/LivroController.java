package com.henrique.projeto.mvc.controller;

import com.henrique.projeto.mvc.model.Categoria;
import com.henrique.projeto.mvc.model.Emprestimo;
import com.henrique.projeto.mvc.model.Livro;
import com.henrique.projeto.mvc.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class LivroController {

    @GetMapping("/livro")
    public String exibirLivro(Model model) {
        // Classificação por gênero ou área
        Categoria categoria = new Categoria("Ficção / Literatura Brasileira", "Literatura", "Clássicos da literatura brasileira");

        // Livro
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-0-0000");
        livro.setAnoPublicacao(1899);
        livro.setCategoria(categoria);

        // Dados do aluno ou membro que realiza empréstimos
        Usuario usuario = new Usuario("Carlos Silva", "2024001", "carlos.silva@universidade.br", "(11) 98765-4321", "Aluno");

        // Registro de retirada e devolução de livros
        Emprestimo emprestimo = new Emprestimo(livro, usuario, LocalDate.now(), LocalDate.now().plusDays(14));

        model.addAttribute("livro", livro);
        model.addAttribute("categoria", categoria);
        model.addAttribute("usuario", usuario);
        model.addAttribute("emprestimo", emprestimo);

        return "livro";
    }
}
