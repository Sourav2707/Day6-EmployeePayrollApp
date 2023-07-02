package com.bridgelabz.employeepayrollapp.dto;

/**
 * DTO - Data Transfer Object it is used to carry data between processes.
 * It reduces the number of calls by holding all the data for the call.
 */
public class EmployeeDTO {
    private String name;
    private long salary;

    public EmployeeDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
