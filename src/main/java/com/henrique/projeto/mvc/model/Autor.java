package com.henrique.projeto.mvc.model;

import java.util.ArrayList;


public class Autor {
    private String nome;
    private String nacionalidade;
    private ArrayList<String> ObrasPublicadas = new ArrayList<String>();

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public ArrayList<String> getObrasPublicadas() {
        return ObrasPublicadas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setObrasPublicadas(ArrayList<String> obrasPublicadas) {
        ObrasPublicadas = obrasPublicadas;
    }
}
