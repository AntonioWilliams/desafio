package com.noxtec.dto;

import com.noxtec.model.Contato;

import java.io.Serializable;

public class ContatoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public ContatoDto() {
    }

    public ContatoDto(Contato contato) {
        id = contato.getId();
        nome = contato.getNome();
        email = contato.getEmail();
        celular = contato.getCelular();
        telefone = contato.getTelefone();
        favorito = contato.getFavorito();
        ativo = contato.getAtivo();
    }

    private Long id;
    private String nome;
    private String email;
    private String celular;
    private String telefone;
    private char favorito;
    private char ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public char getFavorito() {
        return favorito;
    }

    public void setFavorito(char favorito) {
        this.favorito = favorito;
    }

    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }
}
