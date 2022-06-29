package com.projeto.acolhimento.controllers;

import com.projeto.acolhimento.services.CidadeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/consultar-ibge")
    public void consultarIbge() {
        cidadeService.consultarIbge();
    }
}
