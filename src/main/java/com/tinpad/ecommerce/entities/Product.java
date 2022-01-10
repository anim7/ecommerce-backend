package com.tinpad.ecommerce.entities;

import com.tinpad.ecommerce.dto.ProductDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GenericGenerator(name = "product_id", strategy = "com.tinpad.ecommerce.generator.ProductIdGenerator")
    @GeneratedValue(generator = "product_id")
    @Column(length = 9, nullable = false)
    private String productId;

    @Column(nullable = false)
    private String title;

    @Column(length = 10000000, nullable = false)
    private String description;

    @Column(length = 10000000, nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @Column(nullable = false)
    private Long inventory;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(nullable = false)
    private Float rating;

    public Product(String productId, String title, String description, String imgUrl, Double price, Category category, Discount discount, Long inventory, Brand brand, Float rating) {
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

    public Product(String title, String description, String imgUrl, Double price, Category category, Discount discount, Long inventory, Brand brand, Float rating) {
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

    public Product(ProductDTO productDTO) {
        try {
            setProductId(productDTO.getProductId());
        } catch (NullPointerException ignored) {}
        setTitle(productDTO.getTitle());
        setDescription(productDTO.getDescription());
        setImgUrl(productDTO.getImgUrl());
        setPrice(productDTO.getPrice());
        setCategory(new Category(productDTO.getCategory()));
        setDiscount(new Discount(productDTO.getDiscount()));
        setInventory(productDTO.getInventory());
        setBrand(new Brand(productDTO.getBrand()));
        setRating(productDTO.getRating());
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

    public void setCategory(Category category) {
            this.category = category;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setRating(Float rating) {
        if(rating <= 5 && rating > 0) {
            this.rating = rating;
        }
    }

}
