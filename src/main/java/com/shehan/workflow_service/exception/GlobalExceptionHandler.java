package com.shehan.workflow_service.exception;


import com.shehan.workflow_service.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    //handle specific exceptions

    //Resource not found exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException (ResourceNotFoundException exception, WebRequest request){
        ErrorResponse  errorResponseDTO = new ErrorResponse(exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleAPIException (ApiException exception, WebRequest request){
        ErrorResponse  errorResponseDTO = new ErrorResponse(exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }


    //handle global Exceptions
    public ResponseEntity<?> handleGlobalException(Exception exception,WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
