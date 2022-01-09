package com.tinpad.ecommerce.controllers;

import com.tinpad.ecommerce.dto.ProductDTO;
import com.tinpad.ecommerce.entities.Product;
import com.tinpad.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDTO> getProductsById(@RequestParam(name = "id", required = false) String id) {
        return productService.getProductsById(id);
    }

    @GetMapping("/{title}")
    public List<ProductDTO> getProductsByTitle(@PathVariable String title) {
        return productService.getProductsByTitle(title);
    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping
    public List<ProductDTO> deleteProducts(@RequestParam(name = "id", required = false) String id) {
        return productService.deleteProducts(id);
    }

}
