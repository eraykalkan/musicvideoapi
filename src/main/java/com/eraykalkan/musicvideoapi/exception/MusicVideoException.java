package com.eraykalkan.musicvideoapi.exception;


import com.eraykalkan.musicvideoapi.util.ExceptionMessage;

public class MusicVideoException extends XiteServiceException {

    public MusicVideoException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }

}
