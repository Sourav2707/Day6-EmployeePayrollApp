package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeData, Integer> {
    @Query(value="select * from employee_payroll, employee_department where empID = id and department = :department", nativeQuery = true)
    List<EmployeeData> findEmployeesByDepartment(String department);
}
