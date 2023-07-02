package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

/**
 * DTO - Data Transfer Object it is used to carry data between processes.
 * It reduces the number of calls by holding all the data for the call.
 */
public @Data class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name invalid")
    public String name;
    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;
    public String gender;
    public String startDate;
    public String profilePic;
    public String note;
    public List<String> departments;

}
