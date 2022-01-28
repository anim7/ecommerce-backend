package com.tinpad.ecommerce.repositories;

import com.tinpad.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    public List<Product> findByTitle(String title);
    public List<Product> findByCategoryName(String name);
    @Query(value = "SELECT * FROM products WHERE price >= min AND price <= max", nativeQuery = true)
    public List<Product> findByPriceRange(Double min, Double max);
    @Query(value = "SELECT product_id FROM products", nativeQuery = true)
    public List<String> getAllIds();
}
