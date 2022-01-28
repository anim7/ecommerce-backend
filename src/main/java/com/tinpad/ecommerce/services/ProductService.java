package com.tinpad.ecommerce.services;

import com.tinpad.ecommerce.dto.ProductDTO;
import com.tinpad.ecommerce.entities.Product;
import com.tinpad.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getProductsById(String id) {
        if(id != null) {
            Product product = productRepository.findById(id).get();
            ProductDTO productDTO = new ProductDTO(product);
            return List.of(productDTO);
        }
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO(product);
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    public List<ProductDTO> getProductsByCategory(String name) {
        List<Product> products;
        if(name.equalsIgnoreCase("all")) {
            products = productRepository.findAll();
        } else {
            products = productRepository.findByCategoryName(name);
        }
        List<ProductDTO> productDTOs = new ArrayList<>();
        for(Product product : products) {
            ProductDTO productDTO = new ProductDTO(product);
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    public List<ProductDTO> getProductsByCategory(String name, String title) {
        List<Product> productsByTitle = productRepository.findByTitle(title);
        List<ProductDTO> productDTOs = new ArrayList<>();
        if(name.equalsIgnoreCase("all")) {
            for(Product product : productsByTitle) {
                productDTOs.add(new ProductDTO(product));
            }
        } else {
            List<Product> productsByCategory = productRepository.findByCategoryName(name);
            for (Product product : productsByCategory) {
                if (productsByTitle.contains(product)) {
                    productDTOs.add(new ProductDTO(product));
                }
            }
        }
        return productDTOs;
    }

    public List<ProductDTO> getProductsByPriceRange(String name, String title, Double min, Double max) {
        List<ProductDTO> productDTOsCategoryAndTitle = getProductsByCategory(name, title);
        List<ProductDTO> productDTOs;
        if(min != null && max != null) {
            if (max > min) {
                Double temp = min;
                min = max;
                max = temp;
            }
            List<Product> products = productRepository.findByPriceRange(min, max);
            productDTOs = new ArrayList<>();
            for (Product product : products) {
                if (productDTOsCategoryAndTitle.contains(new ProductDTO(product))) {
                    productDTOs.add(new ProductDTO(product));
                }
            }
        } else {
            productDTOs = productDTOsCategoryAndTitle;
        }
        return productDTOs;
    }

    public List<ProductDTO> getProductsByPriceRange(String name, Double min, Double max) {
        List<ProductDTO> productDTOsCategoryAndTitle = getProductsByCategory(name);
        List<ProductDTO> productDTOs;
        if(min != null && max != null) {
            if (max > min) {
                Double temp = min;
                min = max;
                max = temp;
            }
            List<Product> products = productRepository.findByPriceRange(min, max);
            productDTOs = new ArrayList<>();
            for (Product product : products) {
                if (productDTOsCategoryAndTitle.contains(new ProductDTO(product))) {
                    productDTOs.add(new ProductDTO(product));
                }
            }
        } else {
            productDTOs = productDTOsCategoryAndTitle;
        }
        return productDTOs;
    }

    public List<String> getAllIds() {
        return productRepository.getAllIds();
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        productRepository.save(product);
        productDTO.setProductId(product.getProductId());
        return productDTO;
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        productRepository.saveAndFlush(product);
        return productDTO;
    }

    public List<ProductDTO> deleteProducts(String id) {
        List<ProductDTO> productDTOs = getProductsById(id);
        if(id != null) {
            productRepository.deleteById(id);
        } else {
            productRepository.deleteAll();
        }
        return productDTOs;
    }

}
