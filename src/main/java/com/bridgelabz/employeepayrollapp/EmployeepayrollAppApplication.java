package com.bridgelabz.employeepayrollapp;

import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import com.bridgelabz.employeepayrollapp.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Slf4j
public class EmployeepayrollAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeepayrollAppApplication.class, args);
		log.info("Employee Payroll App Started in {} Environment", context.getEnvironment().getProperty("environment"));
		log.info("Employee payroll Db user is {}", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
