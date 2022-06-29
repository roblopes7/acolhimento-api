package com.projeto.acolhimento.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MicrorRegiao {

    private Long id;
    private String nome;
    @JsonAlias("mesorregiao")
    private MesoRegiao mesoregiao;

    public MicrorRegiao(Long id, String nome, MesoRegiao mesoregiao) {
        this.id = id;
        this.nome = nome;
        this.mesoregiao = mesoregiao;
    }

    public MicrorRegiao() {
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

    public MesoRegiao getMesoregiao() {
        return mesoregiao;
    }

    public void setMesoregiao(MesoRegiao mesoregiao) {
        this.mesoregiao = mesoregiao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MicrorRegiao that)) return false;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
