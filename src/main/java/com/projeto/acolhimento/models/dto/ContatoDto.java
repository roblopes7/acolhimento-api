package com.projeto.acolhimento.models.dto;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

public class ContatoDto extends RepresentationModel<ContatoDto> implements Serializable {

    private UUID id;
    private String telefone;
    private String responsavel;
    private String email;

    public ContatoDto(UUID id, String telefone, String responsavel, String email) {
        this.id = id;
        this.telefone = telefone;
        this.responsavel = responsavel;
        this.email = email;
    }

    public ContatoDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContatoDto that)) return false;
        if (!super.equals(o)) return false;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }
}
