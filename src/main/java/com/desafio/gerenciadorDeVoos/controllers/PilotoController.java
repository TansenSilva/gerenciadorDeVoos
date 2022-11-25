package com.desafio.gerenciadorDeVoos.controllers;

import com.desafio.gerenciadorDeVoos.models.AviaoModel;
import com.desafio.gerenciadorDeVoos.models.PilotoModel;
import com.desafio.gerenciadorDeVoos.services.PilotoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pilotos")
public class PilotoController {

    @Autowired
    public PilotoService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PilotoModel>>buscarTodosPilotos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<PilotoModel>>buscarAviaoPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping(path = "/cadastro")
    public ResponseEntity<PilotoModel>cadastarPiloto(@RequestBody PilotoModel pilotoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(pilotoModel));
    }

    @PutMapping(path = "/alterar/{id}")
    public ResponseEntity<PilotoModel>alterarCadastroAviao(@RequestBody PilotoModel pilotoModel, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.alterar(pilotoModel,id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletarPiloto(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado com sucesso!");
    }

}
