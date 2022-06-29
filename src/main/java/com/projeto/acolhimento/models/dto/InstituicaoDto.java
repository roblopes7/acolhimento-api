package com.projeto.acolhimento.models.dto;

import com.projeto.acolhimento.models.Endereco;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InstituicaoDto extends RepresentationModel<InstituicaoDto> implements Serializable {

    private UUID id;
    @NotEmpty(message = "Nome Obrigatório")
    private String nome;
    private String documento;
    private AtuacaoDto atuacao;
    private Integer capacidade;
    private List<ContatoDto> contato = new ArrayList<>();
    private Endereco endereco;

    public InstituicaoDto() {
    }

    public InstituicaoDto(UUID id, String nome, String documento, AtuacaoDto atuacao, Integer capacidade, List<ContatoDto> contato, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.atuacao = atuacao;
        this.capacidade = capacidade;
        this.contato = contato;
        this.endereco = endereco;
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

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public AtuacaoDto getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(AtuacaoDto atuacao) {
        this.atuacao = atuacao;
    }

    public List<ContatoDto> getContato() {
        return contato;
    }

    public void setContato(List<ContatoDto> contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InstituicaoDto that)) return false;
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
