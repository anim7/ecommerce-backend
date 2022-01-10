package com.tinpad.ecommerce.repositories;

import com.tinpad.ecommerce.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {
}
