package com.example.baitaph2buoi1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.baitaph2buoi1.model.Company;
import com.example.baitaph2buoi1.service.CompanyService;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String listCompanies(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "index";
    }

    @PostMapping("/add")
    public String addCompany(@ModelAttribute Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/edit/{id}")
    public String editCompany(@PathVariable Long id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "edit_company";
    }

    @PostMapping("/update")
    public String updateCompany(@ModelAttribute Company company) {
        Company existingCompany = companyService.getCompanyById(company.getId());
        if (existingCompany != null) {
            existingCompany.setName(company.getName()); 
            companyService.saveCompany(existingCompany); 
        }
        return "redirect:/companies";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }

    @GetMapping("/view/{id}")
    public String viewCompany(@PathVariable Long id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "employees";
    }
}