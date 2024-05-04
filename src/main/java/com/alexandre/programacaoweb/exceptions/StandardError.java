package com.alexandre.programacaoweb.exceptions;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.http.HttpStatus;

public class StandardError implements Serializable {

    private String timestamp;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
    private UUID serialVersionUuid;

    public StandardError(String timestamp, HttpStatus status, String error, String message, String path) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getError() {
        return this.error;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPath() {
        return this.path;
    }

    public UUID getSerialVersionUuid() {
        return this.serialVersionUuid;
    }    
    
}
