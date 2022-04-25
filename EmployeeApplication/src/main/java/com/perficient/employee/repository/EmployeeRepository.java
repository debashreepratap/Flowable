package com.perficient.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perficient.employee.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByName(String name);
}