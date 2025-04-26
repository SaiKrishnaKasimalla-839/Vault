package com.example.demo.ExceptionHandling;

public class ErrorResponse {
    private String message;
    private int statusCode;
    private long timestamp;

    public ErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = System.currentTimeMillis();
    }
    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
