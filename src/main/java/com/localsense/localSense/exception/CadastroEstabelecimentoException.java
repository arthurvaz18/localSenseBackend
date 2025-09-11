package com.localsense.localSense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CadastroEstabelecimentoException {

    // Método que trata erros de validação de campos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> errosDeValidacao(MethodArgumentNotValidException excecao) {
        Map<String, String> listaDeErros = new HashMap<>();

        for (FieldError erro : excecao.getBindingResult().getFieldErrors()) {
            listaDeErros.put(erro.getField(), erro.getDefaultMessage());
        }

        return new ResponseEntity<>(listaDeErros, HttpStatus.BAD_REQUEST);
    }

    // Método que trata erros quando eu lanço algo tipo "CNPJ já cadastrado"
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> erroDeNegocio(IllegalArgumentException excecao) {
        Map<String, String> erro = new HashMap<>();
        erro.put("mensagem", excecao.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
}
