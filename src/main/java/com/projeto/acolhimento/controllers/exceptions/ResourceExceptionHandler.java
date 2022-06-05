package com.projeto.acolhimento.controllers.exceptions;

import com.projeto.acolhimento.services.exceptions.BusinessException;
import com.projeto.acolhimento.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,
                                                        HttpServletRequest request){
        StandardError se = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<StandardError> businessViolation(BusinessException e,
                                                        HttpServletRequest request){
        StandardError se = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }
}
