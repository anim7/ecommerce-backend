package com.tinpad.ecommerce.entities;

import com.tinpad.ecommerce.dto.CompanyDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "companies")
public class Company {

    @Id
    @GenericGenerator(name = "company_id", strategy = "com.tinpad.ecommerce.generator.CompanyIdGenerator")
    @GeneratedValue(generator = "company_id")
    @Column(length = 9, nullable = false)
    private String companyId;

    @Column(length = 1000, nullable = false)
    private String name;

    @Column(length = 1000000000, nullable = false)
    private String description;

    @Column(length = 1000000000, nullable = false)
    private String logoUrl;

    public Company(String companyId, String name, String description, String logoUrl) {
        setCompanyId(companyId);
        setName(name);
        setDescription(description);
        setLogoUrl(logoUrl);
    }

    public Company(String name, String description, String logoUrl) {
        setName(name);
        setDescription(description);
        setLogoUrl(logoUrl);
    }

    public Company(CompanyDTO companyDTO) {
        try {
            setCompanyId(companyDTO.getCompanyId());
        } catch(NullPointerException ignore) {}
        setName(companyDTO.getName());
        setDescription(companyDTO.getDescription());
        setLogoUrl(companyDTO.getLogoUrl());
    }

    public void setCompanyId(String companyId) {
        if(companyId != null && companyId.length() == 9) {
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
