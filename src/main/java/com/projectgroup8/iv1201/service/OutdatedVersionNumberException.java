package com.projectgroup8.iv1201.service;

public class OutdatedVersionNumberException extends Exception {
    public OutdatedVersionNumberException(String errorMessage){
        super(errorMessage);
    }
}