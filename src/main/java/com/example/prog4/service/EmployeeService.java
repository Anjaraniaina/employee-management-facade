package com.example.prog4.service;

import com.example.prog4.cnapsrepo.EmployeeCnapsRepository;
import com.example.prog4.cnapsrepo.entity.EmployeeCnapsEntity;
import com.example.prog4.model.EmployeeFilter;
import com.example.prog4.model.exception.NotFoundException;
import com.example.prog4.repository.EmployeeInternRepository;
import com.example.prog4.repository.EmployeeRepositoryFacade;
import com.example.prog4.repository.dao.EmployeeManagerDao;
import com.example.prog4.repository.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeInternRepository repository;
    private EmployeeCnapsRepository employeeCnapsRepository;
    private EmployeeRepositoryFacade employeeRepositoryFacade;


    public Employee getOne(String id) {
        return employeeRepositoryFacade.findOne(id);
    }

    public List<Employee> getAll(EmployeeFilter filter) {
        return employeeRepositoryFacade.findAll(filter);
    }

    public void saveOne(Employee employee) {
        repository.save(employee);
    }
}
