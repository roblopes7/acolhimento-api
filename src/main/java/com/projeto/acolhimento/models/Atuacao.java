package com.projeto.acolhimento.models;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "Atuacao")
public class Atuacao extends RepresentationModel<Atuacao> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid_atuacao")
    private UUID id;

    @Column(name = "descricao")
    private String descricao;

    public Atuacao() {
    }

    public Atuacao(UUID id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atuacao atuacao)) return false;
        if (!super.equals(o)) return false;

        return getId() != null ? getId().equals(atuacao.getId()) : atuacao.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }
}
