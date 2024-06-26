package com.transaction.demo.exception;

public class InsufficientBalance extends RuntimeException {

    public InsufficientBalance(String msg){
        super(msg);
    }
}
