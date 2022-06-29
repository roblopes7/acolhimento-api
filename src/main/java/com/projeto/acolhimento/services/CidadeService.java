package com.projeto.acolhimento.services;

import com.projeto.acolhimento.models.Cidade;
import com.projeto.acolhimento.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class CidadeService {

    @Value("${api.ibge}")
    private String URI_IBGE;

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public void consultarIbge() {

        RestTemplate restTemplate = new RestTemplate();
        Cidade[] cidades = restTemplate.getForObject(URI_IBGE, Cidade[].class);

        if(cidades != null) {
        for (Cidade cidade : cidades) {
            if(cidade != null && cidade.getMicrorregiao() != null && cidade.getMicrorregiao().getMesoregiao() != null) {
                cidade.setUf(cidade.getMicrorregiao().getMesoregiao().getUf());
            }
        }
            cidadeRepository.saveAll(Arrays.asList(cidades));
        }

    }
}
