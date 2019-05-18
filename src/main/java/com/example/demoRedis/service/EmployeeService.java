package com.example.demoRedis.service;


import com.example.demoRedis.entity.Employee;
import com.example.demoRedis.entity.EmployeeDTO;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {
    EmployeeDTO getEmployeeById(String employeeId);

    EmployeeDTO createEmployee(EmployeeDTO employee) throws ParseException;

    EmployeeDTO putEmployee(EmployeeDTO employee) throws ParseException;

    EmployeeDTO deleteEmployeeById(String employeeId);

    List<Employee> getAllEmployee();
}
