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

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
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
