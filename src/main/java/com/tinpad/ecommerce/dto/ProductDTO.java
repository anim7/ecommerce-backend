package com.tinpad.ecommerce.dto;

import com.tinpad.ecommerce.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor
public class ProductDTO {

    private String productId;

    private String title;

    private String description;

    private String imgUrl;

    private Double price;

    private CategoryDTO category;

    private DiscountDTO discount;

    private Long inventory;

    private BrandDTO brand;

    private Float rating;

    public ProductDTO(String productId, String title, String description, String imgUrl, Double price, CategoryDTO category, DiscountDTO discount, Long inventory, BrandDTO brand, Float rating) {
        setProductId(productId);
        setTitle(title);
        setDescription(description);
        setImgUrl(imgUrl);
        setPrice(price);
        setCategory(category);
        setDiscount(discount);
        setInventory(inventory);
        setBrand(brand);
        setRating(rating);
    }

    public ProductDTO(String title, String description, String imgUrl, Double price, CategoryDTO category, DiscountDTO discount, Long inventory, BrandDTO brand, Float rating) {
        setTitle(title);
        setDescription(description);
        setImgUrl(imgUrl);
        setPrice(price);
        setCategory(category);
        setDiscount(discount);
        setInventory(inventory);
        setBrand(brand);
        setRating(rating);
    }

    public ProductDTO(@NotNull Product product) {
        setProductId(product.getProductId());
        setTitle(product.getTitle());
        setDescription(product.getDescription());
        setImgUrl(product.getImgUrl());
        setPrice(product.getPrice());
        setCategory(new CategoryDTO(product.getCategory()));
        setDiscount(new DiscountDTO(product.getDiscount()));
        setInventory(product.getInventory());
        setBrand(new BrandDTO(product.getBrand()));
        setRating(product.getRating());
    }

    public void setProductId(String productId) {
        if(productId != null && productId.length() == 9) {
            this.productId = productId;
        }
    }

    public void setTitle(@NotNull String title) {
        if(title.length() <= 255) {
            this.title = title;
        }
    }

    public void setDescription(@NotNull String description) {
        if(description.length() <= 10000000) {
            this.description = description;
        }
    }

    public void setImgUrl(@NotNull String imgUrl) {
        if(imgUrl.length() <= 10000000) {
            this.imgUrl = imgUrl;
        }
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(CategoryDTO category) {
            this.category = category;
    }

    public void setDiscount(DiscountDTO discount) {
        this.discount = discount;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    public void setRating(Float rating) {
        if(rating <= 5 && rating > 0) {
            this.rating = rating;
        }
    }

}
