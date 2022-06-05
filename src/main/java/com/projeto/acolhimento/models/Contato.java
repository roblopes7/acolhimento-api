package com.projeto.acolhimento.models;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Contato")
public class Contato extends RepresentationModel<Contato> implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid_contato")
    private UUID id;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "responsavel")
    private String responsavel;

    @Column(name = "email")
    private String email;

    public UUID getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEmal() {
        return email;
    }

    public void setEmal(String emal) {
        this.email = emal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        if (!super.equals(o)) return false;

        return getId() != null ? getId().equals(contato.getId()) : contato.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }
}
