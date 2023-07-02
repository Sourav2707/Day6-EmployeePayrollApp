package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class EmployeeData {
    private int empID;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;

    public EmployeeData(int empID, EmployeeDTO employeeDTO) {
        this.empID = empID;
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.startDate = LocalDate.parse(employeeDTO.getStartDate());
        this.note = employeeDTO.getNote();
        this.profilePic = employeeDTO.getProfilePic();
        this.departments = employeeDTO.getDepartments();
    }
    public EmployeeData() {

    }

}
