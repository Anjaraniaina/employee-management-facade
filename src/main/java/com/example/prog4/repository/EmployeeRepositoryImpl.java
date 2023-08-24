package com.example.prog4.repository;

import com.example.prog4.cnapsrepo.EmployeeCnapsRepository;
import com.example.prog4.cnapsrepo.entity.EmployeeCnapsEntity;
import com.example.prog4.model.exception.NotFoundException;
import com.example.prog4.repository.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private final EmployeeInternRepository employeeInternRepository;
    private final EmployeeCnapsRepository employeeCnapsRepository;
    @Override
    public Employee findOne(String id) {
        Employee employeeInter = employeeInternRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found id=" + id));
        EmployeeCnapsEntity employeeCnaps = employeeCnapsRepository
                .findById(employeeInter.getEndToEndId())
                .orElseThrow(
                        () -> new NotFoundException("Not found in cnaps databaseid=" + employeeInter.getEndToEndId())
                );
        return employeeInter.toBuilder().cnaps(employeeCnaps.getCnaps()).build();
    }
}
