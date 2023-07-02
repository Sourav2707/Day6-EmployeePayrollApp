package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    List<EmployeeData> employeeDataList = new ArrayList<>();
    @Override
    public List<EmployeeData> getEmployeeData() {
        return employeeDataList;
    }

    @Override
    public EmployeeData getEmplyeeDataByID(int empID) {

        return employeeDataList.stream().filter(employeeData -> employeeData.getEmpID() == empID).findFirst().orElseThrow(() ->new EmployeeException("Employee Not Found"));
    }

    @Override
    public EmployeeData createEmployeeData(EmployeeDTO employeeDTO) {
        EmployeeData employeeData = new EmployeeData(employeeDataList.size()+1, employeeDTO);
        employeeDataList.add(employeeData);
        return employeeData;
    }

    @Override
    public EmployeeData updateEmployeeData(int empID, EmployeeDTO employeeDTO) {
        EmployeeData employeeData = this.getEmplyeeDataByID(empID);
        employeeData.setName(employeeDTO.getName());
        employeeData.setSalary(employeeDTO.getSalary());
        return employeeData;
    }

    @Override
    public void deleteEmployeeData(int empID) {
        employeeDataList.remove(empID-1);
    }
}
