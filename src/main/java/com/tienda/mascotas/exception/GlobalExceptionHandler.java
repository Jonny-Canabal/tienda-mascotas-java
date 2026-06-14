package com.tienda.mascotas.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**Escucha los errores de todos los controladores*/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex){

        System.out.println(ex.getBindingResult().getFieldErrors());

        List<String> errors = new ArrayList<>();

        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.add(error.getField()+": "+error.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(errors);
    }
}
