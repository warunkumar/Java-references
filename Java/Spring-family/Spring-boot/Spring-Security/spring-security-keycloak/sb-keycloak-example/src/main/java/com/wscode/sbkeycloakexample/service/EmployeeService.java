package com.wscode.sbkeycloakexample.service;

import com.wscode.sbkeycloakexample.entity.Employee;
import com.wscode.sbkeycloakexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostConstruct
    public void initializeEmployeeTable(){
        employeeRepository.saveAll(
                Stream.of(
                        new Employee("A1",2000),
                        new Employee("A2",3000),
                        new Employee("A3",4000)

                ).collect(Collectors.toList()));
    }

    public Employee getEmployee(int empId){
        return employeeRepository.findById(empId).orElse(null);

    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();

    }

}
