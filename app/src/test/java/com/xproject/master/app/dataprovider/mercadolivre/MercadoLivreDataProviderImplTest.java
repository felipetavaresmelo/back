package com.xproject.master.app.dataprovider.mercadolivre;

import com.xproject.master.app.dataprovider.mercadolivre.client.MercadoLivreAuthClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class MercadoLivreDataProviderImplTest {


    @InjectMocks
    MercadoLivreDataProviderImpl mercadoLivreDataProviderImpl;

    @Mock
    MercadoLivreAuthClient mercadoLivreAuthClient;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getProductItem() {
    }

    @Test
    @DisplayName("Gerar de codigo de autenticação com sucesso")
    void givenCalledCodeGenerator_thenExecuteGetMethod() {

        mercadoLivreDataProviderImpl.codeGenerator("5015416049573419", "http://localhost:8080");

        verify(mercadoLivreDataProviderImpl, times(1)).codeGenerator(any(), any());
    }
}