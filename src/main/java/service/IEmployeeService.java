package service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeData> getEmployeeData();
    EmployeeData getEmplyeeDataByID(int empID);
    EmployeeData createEmployeeData(EmployeeDTO employeeDTO);
    EmployeeData updateEmployeeData(EmployeeDTO employeeDTO);
    void deleteEmployeeData(int empID);
}
