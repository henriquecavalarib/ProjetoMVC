package com.henrique.projeto.mvc.controller;

import com.henrique.projeto.mvc.model.Categoria;
import com.henrique.projeto.mvc.model.Emprestimo;
import com.henrique.projeto.mvc.model.Livro;
import com.henrique.projeto.mvc.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/livros", "/livro"})
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio() {
        return "livros/inicio";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livros);
        return "livros/listar";
    }

    @PostMapping
    public String adicionarLivros(@ModelAttribute Livro livro) {
        livros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping("/detalhes")
    public String exibirLivro(Model model) {
        Categoria categoria = new Categoria("Ficção / Literatura Brasileira", "Literatura", "Clássicos da literatura brasileira");

        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-0-0000");
        livro.setAnoPublicacao(1899);
        livro.setCategoria(categoria);

        Usuario usuario = new Usuario("Carlos Silva", "2024001", "carlos.silva@universidade.br", "(11) 98765-4321", "Aluno");

        Emprestimo emprestimo = new Emprestimo(livro, usuario, LocalDate.now(), LocalDate.now().plusDays(14));

        model.addAttribute("livro", livro);
        model.addAttribute("categoria", categoria);
        model.addAttribute("usuario", usuario);
        model.addAttribute("emprestimo", emprestimo);

        return "livro";
    }
}
