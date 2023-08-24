package com.example.prog4.cnapsrepo;

import com.example.prog4.cnapsrepo.entity.EmployeeCnapsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCnapsRepository extends JpaRepository<EmployeeCnapsEntity, String> {
}