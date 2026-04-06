package br.com.ulerich.despachante_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TratadorDeErros {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> lidarComErrosDeValidacao(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();


        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nomeDoCampo = ((FieldError) error).getField();
            String mensagemDeErro = error.getDefaultMessage();
            erros.put(nomeDoCampo, mensagemDeErro);
        });

        return erros;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public Map<String, String> lidarComDadosDuplicados() {
        Map<String, String> erro = new HashMap<>();
        // Trocamos a mensagem para ficar universal!
        erro.put("erro", "Já existe um registro com este dado exclusivo (CPF, Placa ou Renavam) no sistema.");
        return erro;
    }
}