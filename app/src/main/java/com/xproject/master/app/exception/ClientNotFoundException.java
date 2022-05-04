package com.xproject.master.app.exception;

public class ClientNotFoundException extends Exception{
    public ClientNotFoundException (String errorMessage) {
        super(errorMessage);
    }
}
