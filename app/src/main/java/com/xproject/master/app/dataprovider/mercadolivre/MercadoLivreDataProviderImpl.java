package com.xproject.master.app.dataprovider.mercadolivre;

import com.xproject.master.app.dataprovider.mercadolivre.client.MercadoLivreClient;
import com.xproject.master.app.dataprovider.mercadolivre.dto.ProductItemDto;
import com.xproject.master.app.mappers.ProductMapper;
import com.xproject.master.domain.dataprovider.MercadoLivreDataProvider;
import com.xproject.master.domain.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MercadoLivreDataProviderImpl implements MercadoLivreDataProvider {

    @Autowired
    private MercadoLivreClient mercadoLivreClient;

    @Override
    public Product getProductItem(String item){
        ProductItemDto productItemDto = mercadoLivreClient.getProductItem(item);

        return ProductMapper.INSTANCE.productItemDtoToProduct(productItemDto);
    }
}
