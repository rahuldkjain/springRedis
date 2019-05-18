package com.example.demoRedis.service.Impl;

import com.example.demoRedis.entity.Employee;
import com.example.demoRedis.entity.EmployeeDTO;
import com.example.demoRedis.repository.Impl.EmployeeRepositoryImpl;
import com.example.demoRedis.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepositoryImpl employeeRepository;

    @Override
    public EmployeeDTO getEmployeeById(String employeeId){
        Employee result = employeeRepository.findOne(employeeId);
        EmployeeDTO resultDTO = new EmployeeDTO();
        BeanUtils.copyProperties(result, resultDTO);
        System.out.println("Result: "+ result);
        return resultDTO;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) throws ParseException {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);

        //I want to save password to the database
        Date dateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse("13/05/2019");
        employee.setDateOfJoining(dateOfJoining);
        employee.setActive(true);
        Employee result = employeeRepository.save(employee);
        EmployeeDTO resultDTO = new EmployeeDTO();
        BeanUtils.copyProperties(result, resultDTO);

        //System.out.println("result: " + result);
        //System.out.println("resultDTO: " + resultDTO.getDateOfBirth());
        return resultDTO;
    }

    @Override
    public EmployeeDTO putEmployee(EmployeeDTO employeeDTO) throws ParseException {
        EmployeeDTO employeeDTO1 = getEmployeeById(employeeDTO.getEmployeeId());

        if (employeeDTO1 != null){
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO, employee);
            Date dateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse("13/05/2019");
            employee.setDateOfJoining(dateOfJoining);
            employee.setActive(false);
            Employee result = employeeRepository.save(employee);
            EmployeeDTO resultDTO = new EmployeeDTO();
            BeanUtils.copyProperties(result, resultDTO);
            return resultDTO;
        }

        return employeeDTO;
    }

    @Override
    public EmployeeDTO deleteEmployeeById(String employeeId) {

        EmployeeDTO employeeDTO = getEmployeeById(employeeId);
        if (employeeDTO != null){
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO, employee);
            employeeRepository.delete(employee.getEmployeeId());
        }

        return employeeDTO;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}