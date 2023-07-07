package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import com.bridgelabz.employeepayrollapp.model.MailData;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bridgelabz.employeepayrollapp.service.IEmployeeService;

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
    public ResponseEntity<ResponseDTO> addEmployeeData(@Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeData employeeData = employeeService.createEmployeeData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Data Successfully", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeeData(@Valid @PathVariable("id") int id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeData employeeData = employeeService.updateEmployeeData(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Data Successfully", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empID}")
    public ResponseEntity<ResponseDTO> deleteEmployeeData(@PathVariable("empID") int empID) {
        employeeService.deleteEmployeeData(empID);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted ID : "+empID);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable("department") String department) {
        List<EmployeeData> employeeDataList = employeeService.getEmployeeByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get call for ID successfull", employeeDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody MailData mailData) throws MessagingException {
        return employeeService.sendEmail(mailData);
    }
}
