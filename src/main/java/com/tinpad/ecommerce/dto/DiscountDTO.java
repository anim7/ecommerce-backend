package com.tinpad.ecommerce.dto;

import com.tinpad.ecommerce.entities.Discount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor
public class DiscountDTO {

    private String discountId;

    private String name;

    private String description;

    private Double discountPercent;

    private Boolean active;

    public DiscountDTO(String discountId, String name, String description, Double discountPercent, Boolean active) {
        setDiscountId(discountId);
        setName(name);
        setDescription(description);
        setDiscountPercent(discountPercent);
        setActive(active);
    }

    public DiscountDTO(String name, String description, Double discountPercent, Boolean active) {
        setName(name);
        setDescription(description);
        setDiscountPercent(discountPercent);
        setActive(active);
    }

    public DiscountDTO(@NotNull Discount discount) {
        setDiscountId(discount.getDiscountId());
        setName(discount.getName());
        setDescription(discount.getDescription());
        setDiscountPercent(discount.getDiscountPercent());
        setActive(discount.getActive());
    }

    public void setDiscountId(String discountId) {
        if(discountId != null && discountId.length() == 9) {
            this.discountId = discountId;
        }
    }

    public void setName(@NotNull String name) {
        if(name.length() <= 255) {
            this.name = name;
        }
    }

    public void setDescription(@NotNull String description) {
        if(description.length() <= 1000000) {
            this.description = description;
        }
    }

    public void setDiscountPercent(Double discountPercent) {
        if(discountPercent <= 100 && discountPercent >= 0) {
            this.discountPercent = discountPercent;
        }
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
