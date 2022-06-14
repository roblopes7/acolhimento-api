package com.projeto.acolhimento.controllers;

import com.projeto.acolhimento.models.dto.InstituicaoDto;
import com.projeto.acolhimento.services.InstituicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static com.projeto.acolhimento.utils.ValidacaoUuid.validarUid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/instituicoes")
public class InstituicaoController {

    private final InstituicaoService instituicaoService;

    public InstituicaoController(InstituicaoService instituicaoService) {
        this.instituicaoService = instituicaoService;
    }

    @PostMapping
    public ResponseEntity<InstituicaoDto> adicionar(@RequestBody @Valid InstituicaoDto dto){
        InstituicaoDto instituicao = instituicaoService.adicionarOuAlterar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(instituicao.getId()).toUri();
        return ResponseEntity.created(uri).body(instituicao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstituicaoDto> consultar(@PathVariable(value = "id") String id) {
        InstituicaoDto instituicaoDto = instituicaoService.consultar(id);
        return new ResponseEntity<>(instituicaoDto.add(linkTo(methodOn(InstituicaoController.class).consultar(id)).withSelfRel()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstituicaoDto> alterar(@RequestBody @Valid InstituicaoDto dto, @PathVariable(value = "id") String id){
        dto.setId(validarUid(id));
        InstituicaoDto instituicao = instituicaoService.adicionarOuAlterar(dto);
        instituicao.add(linkTo(methodOn(InstituicaoController.class).consultar(id)).withSelfRel());
        return ResponseEntity.ok().body(instituicao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable(value = "id") String id){
        instituicaoService.remover(id);
    }

}
