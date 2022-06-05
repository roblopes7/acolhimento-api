package com.projeto.acolhimento.services;

import com.projeto.acolhimento.models.Atuacao;
import com.projeto.acolhimento.models.dto.AtuacaoDto;
import com.projeto.acolhimento.repositories.AtuacaoRepository;
import com.projeto.acolhimento.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.projeto.acolhimento.utils.ValidacaoUuid.validarUid;

@Service
public class AtuacaoService {

    private final AtuacaoRepository atuacaoRepository;
    private final ModelMapper modelMapper;

    public AtuacaoService(AtuacaoRepository atuacaoRepository, ModelMapper modelMapper) {
        this.atuacaoRepository = atuacaoRepository;
        this.modelMapper = modelMapper;
    }


    public AtuacaoDto adicionarOuAlterar(AtuacaoDto dto) {
        Atuacao atuacao = modelMapper.map(dto, Atuacao.class);
        atuacao = atuacaoRepository.save(atuacao);
        return modelMapper.map(atuacao, AtuacaoDto.class);
    }

    public AtuacaoDto consultar(String id) {
            return modelMapper.map(consultarPorId(id), AtuacaoDto.class);
    }

    public Atuacao consultarPorId(String id){
        Optional<Atuacao> atuacao = atuacaoRepository.findById(validarUid(id));
        if(atuacao.isEmpty()){
            throw new ObjectNotFoundException("Atuação não encontrada");
        }
        return atuacao.get();
    }

    public void remover(String id) {
        atuacaoRepository.delete(consultarPorId(id));
    }
}
