package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import lombok.Data;

@Data
public class EmployeeData {
    private int empID;
    private String name;
    private long salary;

    public EmployeeData(int empID, EmployeeDTO employeeDTO) {
        this.empID = empID;
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
    }
}
