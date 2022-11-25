package com.desafio.gerenciadorDeVoos.services;

import com.desafio.gerenciadorDeVoos.enums.StatusVoo;
import com.desafio.gerenciadorDeVoos.models.PilotoModel;
import com.desafio.gerenciadorDeVoos.models.VooModel;
import com.desafio.gerenciadorDeVoos.repositories.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class VooService {

    @Autowired
    private VooRepository repository;

    public List<VooModel> buscarTodos(){
        return repository.findAll();
    }

    public Optional<VooModel> buscarPorId(Long id){
        return repository.findById(id);
    }

    public List<VooModel> buscarPorStatus(StatusVoo status){
        return repository.findByStatus(status);
    }

    public VooModel cadastrar(VooModel vooModel){
        return repository.save(vooModel);
    }

    public VooModel alterarStatus(VooModel vooModel, Long id){
        VooModel atualizar = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found = id: " + id));
        atualizar.setStatus(vooModel.getStatus());

        return repository.save(atualizar);
    }

    public VooModel alterar(VooModel vooModel, Long id){
        VooModel atualizar = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found = id: " + id));
        atualizar.setDataPartida(vooModel.getDataPartida());
        atualizar.setHoraPartida(vooModel.getHoraPartida());
        atualizar.setDataChegada(vooModel.getDataChegada());
        atualizar.setHoraChegada(vooModel.getHoraChegada());
        atualizar.setOrigem(vooModel.getOrigem());
        atualizar.setDestino(vooModel.getDestino());

        return repository.save(atualizar);
    }


    public void deletar(Long id){
        repository.deleteById(id);
    }
}
