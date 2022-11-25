package com.desafio.gerenciadorDeVoos.controllers;

import com.desafio.gerenciadorDeVoos.models.AviaoModel;
import com.desafio.gerenciadorDeVoos.services.AviaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "avioes")
public class AviaoController {

    @Autowired
    public AviaoService service;

    @GetMapping
    public ResponseEntity<List<AviaoModel>>buscarTodosAvioes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<AviaoModel>>buscarAviaoPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping(path = "/cadastro")
    public ResponseEntity<AviaoModel>cadastrarAviao(@RequestBody AviaoModel aviaoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(aviaoModel));
    }

    @PutMapping(path = "/alterar/{id}")
    public ResponseEntity<AviaoModel>alterarCadastroAviao(@RequestBody AviaoModel aviaoModel,@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.alterar(aviaoModel,id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletarAviao(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado");
    }
}
