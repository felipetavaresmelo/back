package com.xproject.master.domain.dataprovider;

import com.xproject.master.domain.entity.product.Product;

public interface MercadoLivreDataProvider {

    Product getProductItem(String item);
}
