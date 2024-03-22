package com.example.cadastrolistar;

import java.io.Serializable;

public class Lista implements Serializable {
    private String nome;
    private String sobrenome;
    private int identidade;
    private String endereco;
    private int telefone;

    public void setName(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setSobreNome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobreNome() {
        return this.sobrenome;
    }

    public void setIdentidade(int identidade) {
        this.identidade = identidade;
    }

    public int getIdentidade() {
        return this.identidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getTelefone() {
        return this.telefone;
    }

}
