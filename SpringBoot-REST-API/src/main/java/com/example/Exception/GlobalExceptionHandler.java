package com.example.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /////  handle specific exceptions /////

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request)
    {
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false),"404 Not Found");
        return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(APIException.class)
    public
    ResponseEntity<?> handleApiException(APIException exception, WebRequest request)
    {
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false),"404 Not Found");
        return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
    }


    ///////  handle global exceptions  //////

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception,WebRequest request)
    {
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false),"Internal Server Error");
        return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
