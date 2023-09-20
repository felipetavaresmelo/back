package com.xproject.master.app.dataprovider.mercadolivre.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MercadoLivreAuthClient", url = "https://auth.mercadolivre.com.br")
public interface MercadoLivreAuthClient {

    @RequestMapping(method = RequestMethod.GET, value = "/authorization", produces = "application/json")
    //@Headers("Content-Type: application/json, Authorization: {requester}")
    void codeGenerator(@RequestParam("response_type") String responseType, @RequestParam("client_id") String clientId, @RequestParam("redirect_uri") String redirectUri, @RequestParam("state") String state);
}
