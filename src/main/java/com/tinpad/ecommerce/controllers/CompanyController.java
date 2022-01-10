package com.tinpad.ecommerce.controllers;

import com.tinpad.ecommerce.dto.CompanyDTO;
import com.tinpad.ecommerce.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<CompanyDTO> getCompaniesById(@RequestParam(name = "id", required = false) String id) {
        return companyService.getCompaniesById(id);
    }

    @PostMapping
    public CompanyDTO addCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.addCompany(companyDTO);
    }

    @PutMapping
    public CompanyDTO updateCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.updateCompany(companyDTO);
    }

    @DeleteMapping
    public List<CompanyDTO> deleteCompanies(@RequestParam(name = "id", required = false) String id) {
        return companyService.deleteCompanies(id);
    }

}
