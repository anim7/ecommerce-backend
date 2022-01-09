package com.tinpad.ecommerce.dto;

import com.tinpad.ecommerce.entities.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor
public class CategoryDTO {

    private String categoryId;

    private String name;

    private String description;

    private String imgUrl;

    public CategoryDTO(String categoryId, String name, String description, String imgUrl) {
        setCategoryId(categoryId);
        setName(name);
        setDescription(description);
        setImgUrl(imgUrl);
    }

    public CategoryDTO(String name, String description, String imgUrl) {
        setName(name);
        setDescription(description);
        setImgUrl(imgUrl);
    }

    public CategoryDTO(@NotNull Category category) {
        setCategoryId(category.getCategoryId());
        setName(category.getName());
        setDescription(category.getDescription());
        setImgUrl(category.getImgUrl());
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
