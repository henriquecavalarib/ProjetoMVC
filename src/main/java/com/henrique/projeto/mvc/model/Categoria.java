package com.henrique.projeto.mvc.model;

/**
 * Representa a classificação dos livros por gênero ou área do conhecimento.
 */
public class Categoria {
    private String nome;
    private String area;
    private String descricao;

    public Categoria() {
    }

    public Categoria(String nome, String area, String descricao) {
        this.nome = nome;
        this.area = area;
        this.descricao = descricao;
    }

    public Categoria(String nome, String area) {
        this.nome = nome;
        this.area = area;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome + (area != null && !area.isBlank() ? " (" + area + ")" : "");
    }
}
