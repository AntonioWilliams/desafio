package com.noxtec.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "contato", schema = "desafio")
public class Contato  implements Serializable {

    private static final long serialVersionUID = 1L;

    public Contato(Long id, String nome, String email, String celular, String telefone, Character favorito, Character ativo, OffsetDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.telefone = telefone;
        this.favorito = favorito;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }


    public Contato() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contato_id")
    private Long id;
    @Column(name = "contato_nome",  length = 100 )
    private String nome;
    @Column(name = "contato_email",  length = 100 )
    private String email;
    @Column(name = "contato_celular",  length = 11 )
    private String celular;
    @Column(name = "contato_telefone",  length = 10 )
    private String telefone;
    @Column(name = "contato_sn_favorito", columnDefinition = "CHAR(1)", length = 1)
    private Character favorito;

    @Column(name = "contato_sn_ativo", columnDefinition = "CHAR(1)", length = 1)
    private Character ativo;

    @Column(name = "contato_dh_cad")
    @CreationTimestamp()
    private OffsetDateTime dataCadastro;

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

    public Character getFavorito() {
        return favorito;
    }

    public void setFavorito(Character favorito) {
        this.favorito = favorito;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public OffsetDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(OffsetDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
