package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

/**
 * DTO - Data Transfer Object it is used to carry data between processes.
 * It reduces the number of calls by holding all the data for the call.
 */
public @Data class EmployeeDTO {
    private String name;
    private long salary;
}
