package com.projeto.acolhimento.services;

import com.projeto.acolhimento.models.Contato;
import com.projeto.acolhimento.models.dto.ContatoDto;
import com.projeto.acolhimento.repositories.ContatoRepository;
import com.projeto.acolhimento.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.projeto.acolhimento.utils.ValidacaoUuid.validarUid;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final ModelMapper modelMapper;

    public ContatoService(ContatoRepository contatoRepository, ModelMapper modelMapper) {
        this.contatoRepository = contatoRepository;
        this.modelMapper = modelMapper;
    }


    public ContatoDto adicionarOuAlterar(ContatoDto dto) {
        Contato contato = modelMapper.map(dto, Contato.class);
        contato = contatoRepository.save(contato);
        return modelMapper.map(contato, ContatoDto.class);
    }

    public ContatoDto consultar(String id) {
        return modelMapper.map(consultarPorId(id), ContatoDto.class);
    }

    public Contato consultarPorId(String id){
        Optional<Contato> contato = contatoRepository.findById(validarUid(id));
        if(contato.isEmpty()){
            throw new ObjectNotFoundException("Contato não encontrado");
        }
        return contato.get();
    }
}
