package com.tinpad.ecommerce.services;

import com.tinpad.ecommerce.dto.CompanyDTO;
import com.tinpad.ecommerce.entities.Company;
import com.tinpad.ecommerce.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyDTO> getCompaniesById(String id) {
        if(id != null) {
            Company company = companyRepository.findById(id).get();
            return List.of(new CompanyDTO(company));
        }
        List<Company> companies = companyRepository.findAll();
        List<CompanyDTO> companyDTOs = new ArrayList<>();
        for(Company company : companies) {
            companyDTOs.add(new CompanyDTO(company));
        }
        return companyDTOs;
    }

    public CompanyDTO addCompany(CompanyDTO companyDTO) {
        Company company = new Company(companyDTO);
        companyRepository.save(company);
        companyDTO.setCompanyId(company.getCompanyId());
        return companyDTO;
    }

    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        companyRepository.saveAndFlush(new Company(companyDTO));
        return companyDTO;
    }

    public List<CompanyDTO> deleteCompanies(String id) {
        List<CompanyDTO> companyDTOs = getCompaniesById(id);
        if(id != null) {
            companyRepository.deleteById(id);
        } else {
            companyRepository.deleteAll();
        }
        return companyDTOs;
    }

}
