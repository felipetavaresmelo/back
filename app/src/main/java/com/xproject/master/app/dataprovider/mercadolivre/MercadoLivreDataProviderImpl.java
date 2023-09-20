package com.xproject.master.app.dataprovider.mercadolivre;

import com.xproject.master.app.dataprovider.mercadolivre.client.MercadoLivreAuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class MercadoLivreDataProviderImpl {

    @Autowired
    private MercadoLivreAuthClient mercadoLivreAuthClient;

    public MercadoLivreDataProviderImpl(MercadoLivreAuthClient mercadoLivreAuthClient) {
        this.mercadoLivreAuthClient = mercadoLivreAuthClient;
    }

    public void codeGenerator(String clientId, String redirectUri) {

        int randomInt = new SecureRandom().nextInt();
        randomInt = randomInt < 0 ? (randomInt * -1) : randomInt;
        String state = String.valueOf(randomInt);

        mercadoLivreAuthClient.codeGenerator("code", clientId, redirectUri, state);
    }
}
