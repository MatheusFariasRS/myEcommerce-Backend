package com.ecommerce.myecommerce.services.exceptions;

public class ForbiddenException extends RuntimeException {


    public ForbiddenException(String msg){
        super(msg);
    }
}
