package com.desafio.gerenciadorDeVoos.controllers;

import com.desafio.gerenciadorDeVoos.enums.StatusVoo;
import com.desafio.gerenciadorDeVoos.models.VooModel;
import com.desafio.gerenciadorDeVoos.services.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/voos")
public class VooController {

    @Autowired
    public VooService service;

    @GetMapping
    public ResponseEntity<List<VooModel>>buscarTodosVoos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<VooModel>>bucarVooPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @GetMapping(path = "/status/{status}")
    public ResponseEntity<List<VooModel>>buscarVooPorStatus(@PathVariable StatusVoo status){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(service.buscarPorStatus(status));
    }

    @PostMapping(path = "/cadastro")
    public ResponseEntity<VooModel>cadastrarVoo(@RequestBody VooModel vooModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(vooModel));
    }

    @PutMapping(path = "/alterar/{id}")
    public ResponseEntity<VooModel>alterarVoo(@RequestBody VooModel vooModel, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.alterar(vooModel,id));
    }

    @PutMapping(path = "/alterar/status/{id}")
    public ResponseEntity<VooModel>alterarStatusVoo(@RequestBody VooModel vooModel, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.alterarStatus(vooModel,id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletarVoo(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado com sucesso!");
    }
}
