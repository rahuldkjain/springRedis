package com.example.demoRedis.repository;
import com.example.demoRedis.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> findAll();

    public Employee findOne(String employeeId);

    public Employee save(Employee employee);

    public Employee insert(Employee employee);

    public void delete(String employeeId);

    public void deleteAll();

    public boolean exists(String employeeId);

    public Long count();
}
