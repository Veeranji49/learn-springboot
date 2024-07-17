package com.example.ExceptionHandling;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {		

	/////  handle specific exceptions /////
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false),null);
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> handleApiException(APIException exception, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false),null);
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	
	///////  handle global exceptions  //////
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception,WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false),null);
		return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	/*
	 
	 
    "timestamp": "2024-02-04T11:11:05.487+00:00",
    "message": "User id is not found :76",
    "details": "uri=/exception/api/v1/resource/delete/76",
    "status": null
    
    
	 */
}
