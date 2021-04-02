package com.eraykalkan.musicvideoapi.exception;


import com.eraykalkan.musicvideoapi.util.ExceptionMessage;
import lombok.Getter;

@Getter
public class XiteServiceException extends RuntimeException {

    private ExceptionMessage exceptionMessage;

    private XiteServiceException() {

    }

    public XiteServiceException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getValue());
        this.exceptionMessage = exceptionMessage;
    }

    public XiteServiceException(String customExceptionMessage) {
        super(customExceptionMessage);
    }


}
