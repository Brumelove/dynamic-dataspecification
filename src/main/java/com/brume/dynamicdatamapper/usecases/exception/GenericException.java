package com.brume.dynamicdatamapper.usecases.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GenericException {

    @ExceptionHandler(UserRequestAPIException.class)
    public ResponseEntity<ErrorDTO> globalErrorHandler(UserRequestAPIException exception) {
        return new ResponseEntity<> (exception.getErrorDTO(), HttpStatus.BAD_REQUEST);
    }


}
