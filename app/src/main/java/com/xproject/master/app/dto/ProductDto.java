package com.xproject.master.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private Integer availableQuantity;
    private Integer soldQuantity;
    private Double originalPrice;
    private Double price;
}
