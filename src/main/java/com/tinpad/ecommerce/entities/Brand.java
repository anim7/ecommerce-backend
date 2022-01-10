package com.tinpad.ecommerce.entities;

import com.tinpad.ecommerce.dto.BrandDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "brands")
public class Brand {

    @Id
    @GenericGenerator(name = "brand_id", strategy = "com.tinpad.ecommerce.generator.BrandIdGenerator")
    @GeneratedValue(generator = "brand_id")
    @Column(length = 9, nullable = false)
    private String brandId;

    @Column(length = 1000, nullable = false)
    private String name;

    @Column(length = 1000000000, nullable = false)
    private String description;

    @Column(length = 1000000000, nullable = false)
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Brand(String brandId, String name, String description, String imgUrl, Company company) {
        setBrandId(brandId);
        setName(name);
        setDescription(description);
        setImgUrl(imgUrl);
        setCompany(company);
    }

    public Brand(String name, String description, String imgUrl, Company company) {
        setName(name);
        setDescription(description);
        setImgUrl(imgUrl);
        setCompany(company);
    }

    public Brand(BrandDTO brandDTO) {
        try {
            setBrandId(brandDTO.getBrandId());
        } catch(NullPointerException ignore) {}
        setName(brandDTO.getName());
        setDescription(brandDTO.getDescription());
        setImgUrl(brandDTO.getImgUrl());
        setCompany(new Company(brandDTO.getCompany()));
    }

    public void setBrandId(String brandId) {
        if(brandId != null && brandId.length() == 9) {
            this.brandId = brandId;
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

    public void setImgUrl(@NotNull String imgUrl) {
        if(imgUrl.length() <= 1000000000) {
            this.imgUrl = imgUrl;
        }
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
