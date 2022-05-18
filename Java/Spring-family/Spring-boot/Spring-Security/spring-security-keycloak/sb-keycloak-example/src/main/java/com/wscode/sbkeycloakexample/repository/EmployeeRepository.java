package com.wscode.sbkeycloakexample.repository;

import com.wscode.sbkeycloakexample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
