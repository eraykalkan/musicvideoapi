package com.eraykalkan.musicvideoapi.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ApiError implements Serializable {

    private HttpStatus status;

    private String errorMessage;

    private String errorCode;

    private String debugMessage;

    private String uuid;

    private LocalDateTime timestamp;

}
