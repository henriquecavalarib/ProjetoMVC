package com.henrique.projeto.mvc.model;

import java.time.LocalDate;

/**
 * Representa o registro de retirada (empréstimo) e devolução de um livro por um usuário.
 */
public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataRetirada;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private String status; // "Ativo", "Devolvido", "Atrasado"

    public Emprestimo() {
        this.dataRetirada = LocalDate.now();
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(14); // Prazo padrão: 14 dias
        this.status = "Ativo";
    }

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataRetirada, LocalDate dataPrevistaDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataRetirada = dataRetirada;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.status = "Ativo";
        if (livro != null) {
            livro.setDisponivel(false);
        }
    }


    public void registrarDevolucao() {
        registrarDevolucao(LocalDate.now());
    }


    public void registrarDevolucao(LocalDate data) {
        this.dataDevolucao = data;
        this.status = "Devolvido";
        if (this.livro != null) {
            this.livro.setDisponivel(true);
        }
    }


    public boolean isAtrasado() {
        if ("Devolvido".equalsIgnoreCase(this.status)) {
            return false;
        }
        return LocalDate.now().isAfter(this.dataPrevistaDevolucao);
    }


    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        if ("Ativo".equalsIgnoreCase(status) && isAtrasado()) {
            return "Atrasado";
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Empréstimo: " + (livro != null ? livro.getTitulo() : "Sem livro") +
                " para " + (usuario != null ? usuario.getNome() : "Sem usuário") +
                " | Retirada: " + dataRetirada +
                " | Devolução prevista: " + dataPrevistaDevolucao +
                " | Status: " + getStatus();
    }
}
