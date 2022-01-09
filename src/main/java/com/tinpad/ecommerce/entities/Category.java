package com.tinpad.ecommerce.entities;

import com.tinpad.ecommerce.dto.CategoryDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GenericGenerator(name = "category_id", strategy = "com.tinpad.ecommerce.generator.CategoryIdGenerator")
    @GeneratedValue(generator = "category_id")
    @Column(length = 9, nullable = false)
    private String categoryId;

    @Column(nullable = false)
    private String name;

    @Column(length = 100000, nullable = false)
    private String description;

    @Column(length = 10000000, nullable = false)
    private String imgUrl;

    public Category(String categoryId, String name, String description, String imgUrl) {
        setCategoryId(categoryId);
        setName(name);
        setDescription(description);
        setImgUrl(imgUrl);
    }

    public Category(String name, String description, String imgUrl) {
        setName(name);
        setDescription(description);
        setImgUrl(imgUrl);
    }

    public Category(CategoryDTO categoryDTO) {
        try {
            setCategoryId(categoryDTO.getCategoryId());
        } catch (NullPointerException ignore) {}
        setName(categoryDTO.getName());
        setDescription(categoryDTO.getDescription());
        setImgUrl(categoryDTO.getImgUrl());
    }

    public void setCategoryId(String categoryId) {
        if(categoryId != null && categoryId.length() == 9) {
            this.categoryId = categoryId;
        }
    }

    public void setName(@NotNull String name) {
        if(name.length() <= 255) {
            this.name = name;
        }
    }

    public void setDescription(@NotNull String description) {
        if(description.length() <= 100000) {
            this.description = description;
        }
    }

    public void setImgUrl(@NotNull String imgUrl) {
        if(imgUrl.length() <= 10000000) {
            this.imgUrl = imgUrl;
        }
    }

}
