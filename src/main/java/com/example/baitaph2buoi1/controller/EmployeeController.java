package com.example.baitaph2buoi1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.baitaph2buoi1.model.Company;
import com.example.baitaph2buoi1.model.Employee;
import com.example.baitaph2buoi1.service.CompanyService;
import com.example.baitaph2buoi1.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final CompanyService companyService;

    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee, @RequestParam Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        employee.setCompany(company);
        employeeService.saveEmployee(employee);
        return "redirect:/companies/view/" + companyId;
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit_employee";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee, @RequestParam Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        employee.setCompany(company); 
        employeeService.saveEmployee(employee);
        return "redirect:/companies/view/" + companyId;
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, @RequestParam Long companyId) {
        employeeService.deleteEmployee(id);
        return "redirect:/companies/view/" + companyId;
    }
}