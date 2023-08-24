package com.example.prog4.repository;

import com.example.prog4.model.EmployeeFilter;
import com.example.prog4.repository.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee findOne(String id);

    List<Employee> findAll(EmployeeFilter filter);
}
