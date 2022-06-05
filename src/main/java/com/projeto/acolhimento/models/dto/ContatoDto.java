package com.projeto.acolhimento.models.dto;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

public class ContatoDto extends RepresentationModel<ContatoDto> implements Serializable {

    private UUID uuid;
    private String telefone;
    private String responsavel;
    private String email;
}
