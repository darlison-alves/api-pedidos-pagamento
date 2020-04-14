package com.darlisonalves.cursomc.resources.exceptions;

import com.darlisonalves.cursomc.services.exceptions.ObjectNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
