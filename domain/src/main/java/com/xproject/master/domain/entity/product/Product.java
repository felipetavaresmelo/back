package com.xproject.master.domain.entity.product;

import com.xproject.master.domain.usecase.mercadolivre.ReadProductItemByIdUseCase;
import com.xproject.master.domain.usecase.mercadolivre.impl.ReadProductItemByIdUseCaseImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String mercadoLivreId;
    private String title;
    private String subtitle;
    private String description;
    private Integer availableQuantity;
    private Integer soldQuantity;
    private Double originalPrice;
    private Double price;


    public void loadMercadoLivreData (){

        if(mercadoLivreId.isEmpty()){

            ReadProductItemByIdUseCase readProductItemByIdUseCase = new ReadProductItemByIdUseCaseImpl();

            Product product = readProductItemByIdUseCase.execute(mercadoLivreId);

            loadObject(product);
        }
    }

    private void loadObject (Product product){
        this.id = product.getId();
    }
}
