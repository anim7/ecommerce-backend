package com.tinpad.ecommerce.entities;

import com.tinpad.ecommerce.dto.DiscountDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "discounts")
@Getter
@NoArgsConstructor
public class Discount {

    @Id
    @GenericGenerator(name = "discount_id", strategy = "com.tinpad.ecommerce.generator.DiscountIdGenerator")
    @GeneratedValue(generator = "discount_id")
    @Column(length = 9, nullable = false)
    private String discountId;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000000, nullable = false)
    private String description;

    @Column(nullable = false)
    private Double discountPercent;

    @Column(nullable = false)
    private Boolean active;

    public Discount(String discountId, String name, String description, Double discountPercent, Boolean active) {
        setDiscountId(discountId);
        setName(name);
        setDescription(description);
        setDiscountPercent(discountPercent);
        setActive(active);
    }

    public Discount(String name, String description, Double discountPercent, Boolean active) {
        setName(name);
        setDescription(description);
        setDiscountPercent(discountPercent);
        setActive(active);
    }

    public Discount(DiscountDTO discountDTO) {
        try {
            setDiscountId(discountDTO.getDiscountId());
        } catch(NullPointerException ignore) {}
        setName(discountDTO.getName());
        setDescription(discountDTO.getDescription());
        setDiscountPercent(discountDTO.getDiscountPercent());
        setActive(discountDTO.getActive());
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
