package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    List<EmployeeData> employeeDataList = new ArrayList<>();
    @Override
    public List<EmployeeData> getEmployeeData() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeData getEmplyeeDataByID(int empID) {

        return employeeRepository.findById(empID).orElseThrow(() ->new EmployeeException("Employee with ID "+empID+" does not exist"));
    }

    @Override
    public EmployeeData createEmployeeData(EmployeeDTO employeeDTO) {
        EmployeeData employeeData = new EmployeeData(employeeDTO);
        log.debug("Emp data :"+employeeData.toString());
        return employeeRepository.save(employeeData);
    }

    @Override
    public EmployeeData updateEmployeeData(int empID, EmployeeDTO employeeDTO) {
        EmployeeData employeeData = this.getEmplyeeDataByID(empID);
        employeeData.updateEmployeeData(employeeDTO);
        return employeeRepository.save(employeeData);
    }

    @Override
    public void deleteEmployeeData(int empID) {
        EmployeeData employeeData = this.getEmplyeeDataByID(empID);
        employeeRepository.delete(employeeData);
    }
}
