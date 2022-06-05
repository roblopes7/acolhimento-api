package com.projeto.acolhimento.models.dto;

import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.UUID;

public class AtuacaoDto extends RepresentationModel<AtuacaoDto> implements Serializable {

    private UUID id;
    @NotEmpty(message = "Descrição Obrigatória.")
    private String descricao;

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
        if (!(o instanceof AtuacaoDto that)) return false;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
