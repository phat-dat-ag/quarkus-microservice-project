package org.example.product.exception;

public class ErrorResponse {
    public int status;
    public String error;
    public String message;
    public String path;

    public ErrorResponse(int status, String error, String message, String path){
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
