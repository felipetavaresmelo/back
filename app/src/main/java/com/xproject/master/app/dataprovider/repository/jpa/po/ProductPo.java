package com.xproject.master.app.dataprovider.repository.jpa.po;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductPo implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String subtitle;
    private String categoryId;
    private String warranty;
    private String description;
    private String condition;
    private String globalPrice;
    private String netWeight;


    private Integer availableQuantity;
    private Integer soldQuantity;
    private Double originalPrice;
    private Double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductPo productPo = (ProductPo) o;
        return id != null && Objects.equals(id, productPo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
