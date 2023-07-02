package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
public @Data class EmployeeData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empID")
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
