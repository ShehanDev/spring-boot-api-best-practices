package com.shehan.workflow_service.exception;

public class ApiException  extends RuntimeException{

    private static  final long serialVersionUID = 1L;
    public ApiException(String message){
        supper(message);
    }

    private void supper(String message) {
    }

}
