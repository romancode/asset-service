package com.kt.asset.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AssetCodeException extends RuntimeException {
    public AssetCodeException(String message){
        super(message);
    }
}
