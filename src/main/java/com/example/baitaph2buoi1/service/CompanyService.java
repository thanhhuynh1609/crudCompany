package com.example.baitaph2buoi1.service;

import org.springframework.stereotype.Service;

import com.example.baitaph2buoi1.model.Company;
import com.example.baitaph2buoi1.repository.CompanyRepository;

import java.util.List;
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}