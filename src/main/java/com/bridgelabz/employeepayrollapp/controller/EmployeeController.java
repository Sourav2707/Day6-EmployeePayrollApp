package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IEmployeeService;

import java.util.List;

/**
 * ResponseEntity represents the whole HTTP response, status code, header and body.
 * Here we use ResponseEntity to display the HTTP status code.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeeData() {
        List<EmployeeData> employeeDataList = employeeService.getEmployeeData();
        ResponseDTO responseDTO = new ResponseDTO("Get call Success", employeeDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{empID}")
    public ResponseEntity<ResponseDTO> getEmployeeData(@PathVariable("empID") int empID) {
        EmployeeData employeeData = employeeService.getEmplyeeDataByID(empID);
        ResponseDTO responseDTO = new ResponseDTO("Get call for ID Success", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeeData(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeData employeeData = employeeService.createEmployeeData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Data Successfully", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeeData(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeData employeeData = employeeService.updateEmployeeData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Data Successfully", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empID}")
    public ResponseEntity<ResponseDTO> deleteEmployeeData(@PathVariable("empID") int empID) {
        employeeService.deleteEmployeeData(empID);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted ID : "+empID);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
