package com.projeto.acolhimento.models;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "instituicao")
public class Instituicao  extends RepresentationModel<Instituicao> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid_instituicao")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "documento")
    private String documento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid_atuacao")
    private Atuacao atuacao;

    @Column(name = "capacidade")
    private Integer capacidade;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="INSTITUICAO_CONTATO",
            joinColumns={@JoinColumn(name="uid_instituicao")},
            inverseJoinColumns={@JoinColumn(name="uid_contato")})
    private List<Contato> contato = new ArrayList<>();

    public Instituicao() {
    }

    public Instituicao(UUID id, String nome, String documento, Atuacao atuacao, Integer capacidade, List<Contato> contato) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.atuacao = atuacao;
        this.capacidade = capacidade;
        this.contato = contato;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Atuacao getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(Atuacao atuacao) {
        this.atuacao = atuacao;
    }

    public List<Contato> getContato() {
        return contato;
    }

    public void setContato(List<Contato> contato) {
        this.contato = contato;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instituicao that)) return false;
        if (!super.equals(o)) return false;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
