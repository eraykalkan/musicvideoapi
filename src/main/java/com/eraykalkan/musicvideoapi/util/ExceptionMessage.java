package com.eraykalkan.musicvideoapi.util;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    MUSICVIDEO_SAVE_UNSUCCESSFUL("600","Music Video cannot be saved"),
    MUSICVIDEO_NOT_FOUND("601","Music video NOT FOUND"),
    MUSICVIDEO_ALREADY_EXISTS("602","Music Video already exists"),
    MUSICVIDEO_RELEASE_DATE_INVALID("603","Release date is not valid"),
    MUSICVIDEOS_NOT_FOUND("604","Music videos could not be FOUND"),
    GENRE_NOT_FOUND("700","Genre Not Found");

    private String code;
    private String value;

    ExceptionMessage(String code, String value){
        this.code = code;
        this.value = value;
    }

}
