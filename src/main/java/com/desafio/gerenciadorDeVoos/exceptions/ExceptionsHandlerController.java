package com.desafio.gerenciadorDeVoos.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionsHandlerController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> exceptionHandlerEntradaInvalida(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>("Campo digitado inválido", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> exceptionHandlerContaNaoCadastrada(NoSuchElementException ex) {
        return new ResponseEntity<>("Id não existente no banco de dados.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> exceptionHandlerBuscaPorTipo(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>("Filtro de busca não existente, favor informar um válido para realizar a busca.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> exceptionIdNaoExistente(EmptyResultDataAccessException ex) {
        return new ResponseEntity<>("Id não existente no banco de dados.", HttpStatus.NOT_FOUND);
    }

}
