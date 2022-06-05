package com.projeto.acolhimento.controllers;

import com.projeto.acolhimento.models.dto.AtuacaoDto;
import com.projeto.acolhimento.services.AtuacaoService;
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
@RequestMapping("/atuacoes")
public class AtuacaoController {

    private final AtuacaoService atuacaoService;

    public AtuacaoController(AtuacaoService atuacaoService) {
        this.atuacaoService = atuacaoService;
    }

    @PostMapping
    public ResponseEntity<AtuacaoDto> adicionar(@RequestBody @Valid AtuacaoDto dto){
        AtuacaoDto atuacao = atuacaoService.adicionarOuAlterar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(atuacao.getId()).toUri();
        return ResponseEntity.created(uri).body(atuacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtuacaoDto> consultar(@PathVariable(value = "id") String id) {
        AtuacaoDto atuacaoDto = atuacaoService.consultar(id);
        return new ResponseEntity<>(atuacaoDto.add(linkTo(methodOn(AtuacaoController.class).consultar(id)).withSelfRel()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtuacaoDto> alterar(@RequestBody @Valid AtuacaoDto dto, @PathVariable(value = "id") String id){
        dto.setId(validarUid(id));
        AtuacaoDto atuacao = atuacaoService.adicionarOuAlterar(dto);
        atuacao.add(linkTo(methodOn(AtuacaoController.class).consultar(id)).withSelfRel());
        return ResponseEntity.ok().body(atuacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable(value = "id") String id){
        atuacaoService.remover(id);
    }

}
