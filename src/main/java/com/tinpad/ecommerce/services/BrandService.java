package com.tinpad.ecommerce.services;

import com.tinpad.ecommerce.dto.BrandDTO;
import com.tinpad.ecommerce.entities.Brand;
import com.tinpad.ecommerce.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<BrandDTO> getBrandsById(String id) {
        if(id != null) {
            Brand brand = brandRepository.findById(id).get();
            return List.of(new BrandDTO(brand));
        }
        List<Brand> brands = brandRepository.findAll();
        List<BrandDTO> brandDTOs = new ArrayList<>();
        for(Brand brand : brands) {
            brandDTOs.add(new BrandDTO(brand));
        }
        return brandDTOs;
    }

    public BrandDTO addBrand(BrandDTO brandDTO) {
        Brand brand = new Brand(brandDTO);
        brandRepository.save(brand);
        brandDTO.setBrandId(brand.getBrandId());
        return brandDTO;
    }

    public BrandDTO updateBrand(BrandDTO brandDTO) {
        brandRepository.saveAndFlush(new Brand(brandDTO));
        return brandDTO;
    }

    public List<BrandDTO> deleteBrands(String id) {
        List<BrandDTO> brandDTOs = getBrandsById(id);
        if(id != null) {
            brandRepository.deleteById(id);
        } else {
            brandRepository.deleteAll();
        }
        return brandDTOs;
    }

}
