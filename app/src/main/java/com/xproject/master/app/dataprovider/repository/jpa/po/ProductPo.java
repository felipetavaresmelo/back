package com.xproject.master.app.dataprovider.repository.jpa.po;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductPo implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private Integer availableQuantity;
    private Integer soldQuantity;
    private Double originalPrice;
    private Double price;
}