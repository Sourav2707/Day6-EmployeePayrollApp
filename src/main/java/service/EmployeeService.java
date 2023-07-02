package service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Override
    public List<EmployeeData> getEmployeeData() {
        List<EmployeeData> employeeDataList = new ArrayList<>();
        employeeDataList.add(new EmployeeData(1, new EmployeeDTO("Sourav", 40000)));
        return employeeDataList;
    }

    @Override
    public EmployeeData getEmplyeeDataByID(int empID) {
        EmployeeData employeeData = new EmployeeData(1, new EmployeeDTO("Hari", 30000));
        return employeeData;
    }

    @Override
    public EmployeeData createEmployeeData(EmployeeDTO employeeDTO) {
        EmployeeData employeeData = new EmployeeData(1, employeeDTO);
        return employeeData;
    }

    @Override
    public EmployeeData updateEmployeeData(EmployeeDTO employeeDTO) {
        EmployeeData employeeData = new EmployeeData(1, employeeDTO);
        return employeeData;
    }

    @Override
    public void deleteEmployeeData(int empID) {
    }
}
