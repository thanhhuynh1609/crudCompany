package com.example.baitaph2buoi1.service;

import org.springframework.stereotype.Service;

import com.example.baitaph2buoi1.model.Company;
import com.example.baitaph2buoi1.model.Employee;
import com.example.baitaph2buoi1.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

