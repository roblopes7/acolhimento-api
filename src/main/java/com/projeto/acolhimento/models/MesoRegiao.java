package com.projeto.acolhimento.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MesoRegiao {

    private Long id;
    private String nome;
    @JsonAlias("UF")
    private UF uf;

    public MesoRegiao(Long id, String nome, UF uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public MesoRegiao() {
    }

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

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MesoRegiao that)) return false;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
