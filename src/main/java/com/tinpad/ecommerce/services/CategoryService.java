package com.tinpad.ecommerce.services;

import com.tinpad.ecommerce.dto.CategoryDTO;
import com.tinpad.ecommerce.entities.Category;
import com.tinpad.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getCategories(String id) {
        if(id != null) {
            Category category = categoryRepository.findById(id).get();
            CategoryDTO categoryDTO = new CategoryDTO(category);
            return List.of(categoryDTO);
        }
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        for(Category category : categories) {
            CategoryDTO categoryDTO = new CategoryDTO(category);
            categoryDTOs.add(categoryDTO);
        }
        return categoryDTOs;
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO);
        categoryRepository.save(category);
        categoryDTO.setCategoryId(category.getCategoryId());
        return categoryDTO;
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO);
        categoryRepository.saveAndFlush(category);
        return categoryDTO;
    }

    public List<CategoryDTO> deleteCategories(String id) {
        List<CategoryDTO> categoryDTOs = getCategories(id);
        if(id != null) {
            categoryRepository.deleteById(id);
        } else {
            categoryRepository.deleteAll();
        }
        return categoryDTOs;
    }

}
