package com.example.prog4.repository;

import com.example.prog4.repository.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee findOne(String id);
}
