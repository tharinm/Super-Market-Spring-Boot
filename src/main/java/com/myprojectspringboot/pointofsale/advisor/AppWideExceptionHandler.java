package com.myprojectspringboot.pointofsale.advisor;

import com.myprojectspringboot.pointofsale.exception.NotFoundException;
import com.myprojectspringboot.pointofsale.utills.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFOundException(NotFoundException e){
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Failed",e.getMessage()), HttpStatus.NOT_FOUND
        );
    }

}
