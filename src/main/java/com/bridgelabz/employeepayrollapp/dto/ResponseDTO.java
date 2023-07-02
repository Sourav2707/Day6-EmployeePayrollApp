package com.bridgelabz.employeepayrollapp.dto;

/**
 * DTO - Data Transfer Object it is used to carry data between processes.
 * It reduces the number of calls by holding all the data for the call.
 */

import lombok.Data;

/**
 * Lombok - @Data is equivalent to using @code @Getter @Setter etc.,
 */

public @Data class ResponseDTO {
    private String message;
    private Object data;
}
