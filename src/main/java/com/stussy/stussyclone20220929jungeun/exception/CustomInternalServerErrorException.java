package com.stussy.stussyclone20220929jungeun.exception;


public class CustomInternalServerErrorException extends  RuntimeException{
    public CustomInternalServerErrorException(String message) {
        super(message);
    }
}
