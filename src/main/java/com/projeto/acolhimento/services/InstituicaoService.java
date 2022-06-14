package com.projeto.acolhimento.services;

import com.projeto.acolhimento.models.Contato;
import com.projeto.acolhimento.models.Instituicao;
import com.projeto.acolhimento.models.dto.ContatoDto;
import com.projeto.acolhimento.models.dto.InstituicaoDto;
import com.projeto.acolhimento.repositories.InstituicaoRepository;
import com.projeto.acolhimento.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.projeto.acolhimento.utils.ValidacaoUuid.validarUid;

@Service
public class InstituicaoService {

    private final InstituicaoRepository instituicaoRepository;
    private final ContatoService contatoService;
    private final ModelMapper modelMapper;

    public InstituicaoService(InstituicaoRepository instituicaoRepository, ContatoService contatoService, ModelMapper modelMapper) {
        this.instituicaoRepository = instituicaoRepository;
        this.contatoService = contatoService;
        this.modelMapper = modelMapper;
    }


    public InstituicaoDto adicionarOuAlterar(InstituicaoDto dto) {
        List<Contato> contatos = new ArrayList<>();
        for(ContatoDto contatoDto: dto.getContato()){
            contatos.add(contatoService.consultarPorId(String.valueOf(contatoDto.getId())));
        }
        Instituicao instituicao = modelMapper.map(dto, Instituicao.class);
        instituicao.setContato(contatos);
        instituicao = instituicaoRepository.save(instituicao);
        return modelMapper.map(instituicao, InstituicaoDto.class);
    }

    public InstituicaoDto consultar(String id) {
            return modelMapper.map(consultarPorId(id), InstituicaoDto.class);
    }

    public Instituicao consultarPorId(String id){
        Optional<Instituicao> instituicao = instituicaoRepository.findById(validarUid(id));
        if(instituicao.isEmpty()){
            throw new ObjectNotFoundException("Atuação não encontrada");
        }
        return instituicao.get();
    }

    public void remover(String id) {
        instituicaoRepository.delete(consultarPorId(id));
    }
}
