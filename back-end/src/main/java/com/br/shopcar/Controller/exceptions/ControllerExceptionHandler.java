package com.br.shopcar.Controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> ResourceNotFoundHandler(EntityNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setMessage(e.getMessage());
        error.setStatus(status.value());
        error.setError("Recurso não encontrado");
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);

    }
}
