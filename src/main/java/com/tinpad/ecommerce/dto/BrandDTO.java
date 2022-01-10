package com.tinpad.ecommerce.dto;

import com.tinpad.ecommerce.entities.Brand;
import com.tinpad.ecommerce.entities.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor
public class BrandDTO {

    private String brandId;

    private String name;

    private String description;

    private String imgUrl;

    private CompanyDTO company;

    public BrandDTO(String brandId, String name, String description, String imgUrl, CompanyDTO company) {
        setBrandId(brandId);
        setName(name);
        setDescription(description);
        setImgUrl(imgUrl);
        setCompany(company);
    }

    public BrandDTO(String name, String description, String imgUrl, CompanyDTO company) {
        setName(name);
        setDescription(description);
        setImgUrl(imgUrl);
        setCompany(company);
    }

    public BrandDTO(Brand brand) {
        try {
            setBrandId(brand.getBrandId());
        } catch(NullPointerException ignore) {}
        setName(brand.getName());
        setDescription(brand.getDescription());
        setImgUrl(brand.getImgUrl());
        setCompany(new CompanyDTO(brand.getCompany()));
    }

    public void setBrandId(@NotNull String brandId) {
        if(brandId.length() == 9) {
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

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

}
