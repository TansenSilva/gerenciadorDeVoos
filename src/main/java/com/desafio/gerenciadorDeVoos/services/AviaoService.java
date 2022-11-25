package com.desafio.gerenciadorDeVoos.services;

import com.desafio.gerenciadorDeVoos.models.AviaoModel;
import com.desafio.gerenciadorDeVoos.models.VooModel;
import com.desafio.gerenciadorDeVoos.repositories.AviaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AviaoService {

    @Autowired
    public AviaoRepository repository;

    public List<AviaoModel> buscarTodos(){
        return repository.findAll();
    }

    public Optional<AviaoModel> buscarPorId(Long id){
        return repository.findById(id);
    }

    public AviaoModel cadastrar(AviaoModel aviaoModel){
        return repository.save(aviaoModel);
    }

    public AviaoModel alterar(AviaoModel aviaoModel, Long id){
        AviaoModel atualizar = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found = id: " + id));
       atualizar.setModelo(aviaoModel.getModelo());
       atualizar.setFabricante(aviaoModel.getFabricante());
       atualizar.setCapacidade(aviaoModel.getCapacidade());
       atualizar.setPrefixo(aviaoModel.getPrefixo());

        return repository.save(atualizar);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }


}
