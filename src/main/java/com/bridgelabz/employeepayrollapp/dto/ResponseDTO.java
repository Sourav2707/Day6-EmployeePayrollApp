package com.bridgelabz.employeepayrollapp.dto;

/**
 * DTO - Data Transfer Object it is used to carry data between processes.
 * It reduces the number of calls by holding all the data for the call.
 */

public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
