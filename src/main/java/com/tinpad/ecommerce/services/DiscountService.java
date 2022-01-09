package com.tinpad.ecommerce.services;

import com.tinpad.ecommerce.dto.DiscountDTO;
import com.tinpad.ecommerce.entities.Discount;
import com.tinpad.ecommerce.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<DiscountDTO> getDiscountsById(String id) {
        if(id != null) {
            Discount discount = discountRepository.findById(id).get();
            return List.of(new DiscountDTO(discount));
        }
        List<Discount> discounts = discountRepository.findAll();
        List<DiscountDTO> discountDTOs = new ArrayList<>();
        for(Discount discount : discounts) {
            discountDTOs.add(new DiscountDTO(discount));
        }
        return discountDTOs;
    }

    public DiscountDTO addDiscount(DiscountDTO discountDTO) {
        Discount discount = new Discount(discountDTO);
        discountRepository.save(discount);
        discountDTO.setDiscountId(discount.getDiscountId());
        return discountDTO;
    }

    public DiscountDTO updateDiscount(DiscountDTO discountDTO) {
        discountRepository.saveAndFlush(new Discount(discountDTO));
        return discountDTO;
    }

    public List<DiscountDTO> deleteDiscounts(String id) {
        List<DiscountDTO> discountDTOs = getDiscountsById(id);
        if(id != null) {
            discountRepository.deleteById(id);
        } else {
            discountRepository.deleteAll();
        }
        return discountDTOs;
    }

}
