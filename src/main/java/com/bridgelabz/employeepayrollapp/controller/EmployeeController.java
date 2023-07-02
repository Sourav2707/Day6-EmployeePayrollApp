package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ResponseEntity represents the whole HTTP response, status code, header and body.
 * Here we use ResponseEntity to display the HTTP status code.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeeData() {
        EmployeeData employeeData = new EmployeeData(1, new EmployeeDTO("Sourav", 40000));
        ResponseDTO responseDTO = new ResponseDTO("Get call Success", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{empID}")
    public ResponseEntity<ResponseDTO> getEmployeeData(@PathVariable("empID") int empID) {
        EmployeeData employeeData = new EmployeeData(1, new EmployeeDTO("Hari", 30000));
        ResponseDTO responseDTO = new ResponseDTO("Get call Success", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeeData(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeData employeeData = new EmployeeData(1, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Data Successfully", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeeData(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeData employeeData = new EmployeeData(1, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Data Successfully", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empID}")
    public ResponseEntity<ResponseDTO> deleteEmployeeData(@PathVariable("empID") int empID) {
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted ID : "+empID);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
