package com.eraykalkan.musicvideoapi.exception;

import com.eraykalkan.musicvideoapi.util.ExceptionMessage;

public class GenreException extends XiteServiceException {

    public GenreException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }

    public GenreException(String customExceptionMessage) {
        super(customExceptionMessage);
    }

}
