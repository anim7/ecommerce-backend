package com.tinpad.ecommerce.dto;

import com.tinpad.ecommerce.entities.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor
public class CompanyDTO {

    private String companyId;

    private String name;

    private String description;

    private String logoUrl;

    public CompanyDTO(String companyId, String name, String description, String logoUrl) {
        setCompanyId(companyId);
        setName(name);
        setDescription(description);
        setLogoUrl(logoUrl);
    }

    public CompanyDTO(String name, String description, String logoUrl) {
        setName(name);
        setDescription(description);
        setLogoUrl(logoUrl);
    }

    public CompanyDTO(Company company) {
        try {
            setCompanyId(company.getCompanyId());
        } catch(NullPointerException ignore) {}
        setName(company.getName());
        setDescription(company.getDescription());
        setLogoUrl(company.getLogoUrl());
    }

    public void setCompanyId(@NotNull String companyId) {
        if(companyId.length() == 9) {
            this.companyId = companyId;
        }
    }

    public void setName(@NotNull String name) {
        if(name.length() <= 1000) {
            this.name = name;
        }
    }

    public void setDescription(@NotNull String description) {
        if(description.length() <= 1000000000) {
            this.description = description;
        }
    }

    public void setLogoUrl(@NotNull String logoUrl) {
        if(logoUrl.length() <= 1000000000) {
            this.logoUrl = logoUrl;
        }
    }

}
