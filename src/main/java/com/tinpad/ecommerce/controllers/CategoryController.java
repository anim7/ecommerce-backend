package com.tinpad.ecommerce.controllers;

import com.tinpad.ecommerce.dto.CategoryDTO;
import com.tinpad.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getCategories(@RequestParam(name = "id", required = false) String id) {
        return categoryService.getCategories(id);
    }

    @PostMapping
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }

    @PutMapping
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping
    public List<CategoryDTO> deleteCategory(@RequestParam(name = "id", required = false) String id) {
        return categoryService.deleteCategories(id);
    }

}
