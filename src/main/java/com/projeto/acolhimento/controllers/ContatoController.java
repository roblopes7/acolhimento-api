package com.projeto.acolhimento.controllers;


import com.projeto.acolhimento.models.dto.ContatoDto;
import com.projeto.acolhimento.services.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<ContatoDto> adicionar(@RequestBody @Valid ContatoDto dto){
        ContatoDto contato = contatoService.adicionarOuAlterar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(contato.getId()).toUri();
        return ResponseEntity.created(uri).body(contato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDto> consultar(@PathVariable(value = "id") String id) {
        ContatoDto contato = contatoService.consultar(id);
        return new ResponseEntity<>(contato.add(linkTo(methodOn(InstituicaoController.class).consultar(id)).withSelfRel()), HttpStatus.OK);
    }

}
