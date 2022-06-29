package com.projeto.acolhimento.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cidade")
public class Cidade extends RepresentationModel<Cidade> implements Serializable {

    @Id
    @Column(name = "id_cidade")
    private Integer id;

    private String nome;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_uf")
    private UF uf;

    @Transient
    @JsonAlias("microrregiao")
    private MicrorRegiao microrregiao;

    public Cidade(Integer id, String nome, UF uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public Cidade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public com.projeto.acolhimento.models.UF getUf() {
        return this.uf;
    }

    public MicrorRegiao getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(MicrorRegiao microrregiao) {
        this.microrregiao = microrregiao;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade cidade)) return false;
        if (!super.equals(o)) return false;

        return getId() != null ? getId().equals(cidade.getId()) : cidade.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }
}
