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

    public List<ProductDTO> getProductsByTitle(String title) {
        List<Product> products = productRepository.findByTitle(title);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for(Product product : products) {
            ProductDTO productDTO = new ProductDTO(product);
            productDTOs.add(productDTO);
        }
        return productDTOs;
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
