package com.stussy.stussyclone20220929jungeun.handler;

import com.stussy.stussyclone20220929jungeun.dto.CMRespDto;
import com.stussy.stussyclone20220929jungeun.exception.CustomInternalServerErrorException;
import com.stussy.stussyclone20220929jungeun.exception.CustomValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice

public class RestControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> validationErrorException(CustomValidationException e){
        return ResponseEntity
                .badRequest()
                .body(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()));
    }

    @ExceptionHandler(CustomInternalServerErrorException.class)
    public ResponseEntity<?> internalServerErrorException(CustomInternalServerErrorException e){
        return ResponseEntity
                .internalServerError()
                .body(new CMRespDto<>(-1, e.getMessage(),null));
    }
}
