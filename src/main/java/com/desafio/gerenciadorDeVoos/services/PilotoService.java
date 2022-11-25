package com.desafio.gerenciadorDeVoos.services;

import com.desafio.gerenciadorDeVoos.models.PilotoModel;
import com.desafio.gerenciadorDeVoos.repositories.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PilotoService {

    @Autowired
    public PilotoRepository repository;

    public List<PilotoModel> buscarTodos(){
        return repository.findAll();
    }

    public Optional<PilotoModel> buscarPorId(Long id){
        return repository.findById(id);
    }

    public PilotoModel cadastrar(PilotoModel pilotoModel){
        return repository.save(pilotoModel);
    }

    public PilotoModel alterar(PilotoModel pilotoModel, Long id){
        PilotoModel atualizar = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found = id: " + id));
        atualizar.setRegistroAnac(pilotoModel.getRegistroAnac());
        atualizar.setNome(pilotoModel.getNome());
        atualizar.setDataDeNascimento(pilotoModel.getDataDeNascimento());
        atualizar.setCpf(pilotoModel.getCpf());

        return repository.save(atualizar);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
