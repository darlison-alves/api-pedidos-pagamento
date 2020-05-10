package com.darlisonalves.cursomc.resources.exceptions;

import com.darlisonalves.cursomc.services.exceptions.DataIntegrityException;
import com.darlisonalves.cursomc.services.exceptions.ObjectNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFountException.class)
    public ResponseEntity<StandardError> objectNotFount(ObjectNotFountException notFountException, HttpServletRequest httpServletRequest) {
        StandardError e = new StandardError(HttpStatus.NOT_FOUND.value(), notFountException.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> DataIntegrity(DataIntegrityException integrityException, HttpServletRequest request ) {
        StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), integrityException.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation( MethodArgumentNotValidException e, HttpServletRequest request ) {
        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());

        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            error.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
