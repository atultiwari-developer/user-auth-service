package com.covid.userauthservice.exception;

import com.covid.userauthservice.common.CommonConstant;
import com.covid.userauthservice.model.ModelApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomAccessDeniedException.class)
    public ResponseEntity<Object> CustomAccessDeniedException(CustomAccessDeniedException ex, WebRequest wb){
        ModelApiResponse modelApiResponse = new ModelApiResponse();
        modelApiResponse.setCode(HttpStatus.UNAUTHORIZED.value());
        modelApiResponse.setMessage(CommonConstant.ERROR_OCCURED_UNAUTHORIZED);
        return new ResponseEntity<Object>(modelApiResponse,HttpStatus.UNAUTHORIZED);
    }
}
