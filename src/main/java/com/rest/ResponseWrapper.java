package com.rest;

import java.io.Serializable;

public class ResponseWrapper implements Serializable {

    private boolean success;

    private String message;

    private String token;

    public ResponseWrapper(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public ResponseWrapper(String message){
        this.success = true;
        this.message = message;
    }
    public ResponseWrapper(String message, String token){
        this.success = true;
        this.message = message;
        this.token = token;
    }

    public ResponseWrapper(){
        this.success = true;
        this.message = "OK";
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}