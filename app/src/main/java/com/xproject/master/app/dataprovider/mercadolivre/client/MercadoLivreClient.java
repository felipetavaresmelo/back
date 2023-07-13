package com.xproject.master.app.dataprovider.mercadolivre.client;

import com.xproject.master.app.dataprovider.mercadolivre.dto.ProductItemDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
    name = "MercadoLivreClient",
    url = "https://api.mercadolibre.com")
public interface MercadoLivreClient {

    //@RequestMapping(method = RequestMethod.GET, value = "/items/{item}", produces = "application/json")
    @RequestLine("GET /items/{item}")
    @Headers("Content-Type: application/json, Authorization: {requester}")
    ProductItemDto getProductItem(@Param("item") String item);

}
