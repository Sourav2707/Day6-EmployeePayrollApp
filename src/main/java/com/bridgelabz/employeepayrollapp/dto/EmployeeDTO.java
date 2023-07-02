package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
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
    @Pattern(regexp = "male|fewmale", message="Gender needs to be male or female")
    public String gender;
    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "start date should not be empty")
    @PastOrPresent(message = "start date should be past or todays date")
    public String startDate;
    @NotBlank(message = "profile pic cannot be empty")
    public String profilePic;
    @NotBlank(message = "Note cannot be empty")
    public String note;
    @NotNull(message = "Department should not be empty")
    public List<String> departments;

}
