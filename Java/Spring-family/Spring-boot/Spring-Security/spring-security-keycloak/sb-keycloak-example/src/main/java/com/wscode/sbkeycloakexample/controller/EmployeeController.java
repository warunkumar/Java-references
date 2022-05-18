package com.wscode.sbkeycloakexample.controller;

import com.wscode.sbkeycloakexample.entity.Employee;
import com.wscode.sbkeycloakexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/{employeeId}")
    @RolesAllowed(value = "user")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId){
        return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }

    @GetMapping
    @RolesAllowed(value = "admin")
    public ResponseEntity<List<Employee>> findAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
