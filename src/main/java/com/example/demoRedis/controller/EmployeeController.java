package com.example.demoRedis.controller;

import com.example.demoRedis.entity.Employee;
import com.example.demoRedis.entity.EmployeeDTO;
import com.example.demoRedis.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl service;

    @GetMapping("/employee")
    public EmployeeDTO getEmployee(@RequestParam String employeeId){
        return service.getEmployeeById(employeeId);
    }

    @PostMapping(value = "/employee", consumes = "application/json")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) throws ParseException {
        return service.createEmployee(employeeDTO);
    }

    @PutMapping(value = "/employee", consumes = "application/json")
    public EmployeeDTO putEmployee(@RequestBody EmployeeDTO employeeDTO) throws ParseException {
        return service.putEmployee(employeeDTO);
    }

    @DeleteMapping("/employee")
    public EmployeeDTO deleteEmployee(@RequestParam String employeeId){
        return service.deleteEmployeeById(employeeId);
    }

    @RequestMapping("/getAllEmployee")
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
    }

}
