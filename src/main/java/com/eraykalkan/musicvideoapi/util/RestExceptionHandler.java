package com.eraykalkan.musicvideoapi.util;

import com.eraykalkan.musicvideoapi.exception.XiteServiceException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.UUID;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            XiteServiceException.class
    })
    protected ResponseEntity<Object> handleException(XiteServiceException ex) {
        ApiError apiError = new ApiError();
        if (ex.getExceptionMessage() != null) {
            apiError.setErrorCode(ex.getExceptionMessage().getCode());
        }
        apiError.setErrorMessage(ex.getMessage());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setUuid(UUID.randomUUID().toString());
        apiError.setStatus(HttpStatus.valueOf(500));

        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
