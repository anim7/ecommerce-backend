package com.tinpad.ecommerce.controllers;

import com.tinpad.ecommerce.dto.DiscountDTO;
import com.tinpad.ecommerce.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping
    public List<DiscountDTO> getDiscountsById(@RequestParam(name = "id", required = false) String id) {
        return discountService.getDiscountsById(id);
    }

    @PostMapping
    public DiscountDTO addDiscount(@RequestBody DiscountDTO discountDTO) {
        return discountService.addDiscount(discountDTO);
    }

    @PutMapping
    public DiscountDTO updateDiscount(@RequestBody DiscountDTO discountDTO) {
        return discountService.updateDiscount(discountDTO);
    }

    @DeleteMapping
    public List<DiscountDTO> deleteDiscounts(@RequestParam(name = "id", required = false) String id) {
        return discountService.deleteDiscounts(id);
    }

}
