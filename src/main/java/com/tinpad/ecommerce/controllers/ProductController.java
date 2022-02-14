package com.tinpad.ecommerce.controllers;

import com.tinpad.ecommerce.dto.ProductDTO;
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

    @GetMapping("/{name}")
    public List<ProductDTO> getProductsByCategory(@PathVariable String name, @RequestParam(name = "min", required = false) Double min, @RequestParam(name = "max", required = false) Double max) {
        return productService.getProductsByPriceRange(name, min, max);
    }

    @GetMapping("/{name}/{title}")
    public List<ProductDTO> getProductsByCategory(@PathVariable String name, @PathVariable String title, @RequestParam(name = "min", required = false) Double min, @RequestParam(name = "max", required = false) Double max) {
        return productService.getProductsByPriceRange(name, title, min, max);
    }

//    @GetMapping("/{id}")
//    public List<ProductDTO> getProductsByIdAndSize(@PathVariable String id, @RequestParam(name = "size") Long size) {
//        return productService.getProductsByIdAndSize(id, size);
//    }

    @GetMapping("/size")
    public Long getNumberOfProducts(@RequestParam(name = "category", required = false) String category, @RequestParam(name = "title", required = false) String title) {
        return productService.getNumberOfProducts(category, title);
    }

    @GetMapping("/ids")
    public List<String> getAllIds() {
        return productService.getAllIds();
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
