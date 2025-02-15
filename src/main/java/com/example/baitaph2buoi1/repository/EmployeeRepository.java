package com.example.baitaph2buoi1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.baitaph2buoi1.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}

