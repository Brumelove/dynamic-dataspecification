package com.brume.dynamicdatamapper.usecases.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestAPIException extends RuntimeException{

    private ErrorDTO errorDTO;

    public UserRequestAPIException(String errorType , String errorName){
        errorDTO = new ErrorDTO();
        errorDTO.setErrorType(errorType);
        errorDTO.setErrorMessage(errorName);
    }
}
