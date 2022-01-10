package com.tinpad.ecommerce.controllers;

import com.tinpad.ecommerce.dto.BrandDTO;
import com.tinpad.ecommerce.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<BrandDTO> getBrandsById(@RequestParam(name = "id", required = false) String id) {
        return brandService.getBrandsById(id);
    }

    @PostMapping
    public BrandDTO addBrand(@RequestBody BrandDTO brandDTO) {
        return brandService.addBrand(brandDTO);
    }

    @PutMapping
    public BrandDTO updateBrand(@RequestBody BrandDTO brandDTO) {
        return brandService.updateBrand(brandDTO);
    }

    @DeleteMapping
    public List<BrandDTO> deleteBrands(@RequestParam(name = "id", required = false) String id) {
        return brandService.deleteBrands(id);
    }

}
