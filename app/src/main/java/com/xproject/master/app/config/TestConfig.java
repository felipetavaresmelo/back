package com.xproject.master.app.config;

import com.xproject.master.app.dataprovider.ClientDataProviderImpl;
import com.xproject.master.app.dataprovider.ProductDataProviderImpl;
import com.xproject.master.domain.entity.client.Client;
import com.xproject.master.domain.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientDataProviderImpl clientDataProvider;

    @Autowired
    private ProductDataProviderImpl productDataProvider;

    @Override
    public void run(String... args) {

        List<Client> clientList = new ArrayList<>();

        Client client1 = new Client();
        client1.setName("Antonio Silva");
        client1.setPhone("988888888");
        clientList.add(client1);

        Client client2 = new Client();
        client2.setName("Alexandre Verde");
        client2.setPhone("977777777");
        clientList.add(client2);

        Client client3 = new Client();
        client3.setName("Maria Brown");
        client3.setPhone("988888888");
        clientList.add(client3);

        Client client4 = new Client();
        client4.setName("Alex Green");
        client4.setPhone("977777777");
        clientList.add(client4);

        clientDataProvider.saveClientList(clientList);

        List<Product> productList = new ArrayList<>();

        Product product1 = new Product();
        product1.setTitle("Smart TV");
        product1.setSubtitle("50pol");
        product1.setDescription("Samsung UTL5000 2012");
        product1.setAvailableQuantity(2);
        product1.setSoldQuantity(1);
        product1.setOriginalPrice(1500.0);
        product1.setPrice(1700.0);

        Product product2 = new Product();
        product2.setTitle("Apple TV");
        product2.setSubtitle("4k");
        product2.setDescription("Apple TV 4k HDMI");
        product2.setAvailableQuantity(50);
        product2.setSoldQuantity(4);
        product2.setOriginalPrice(700.0);
        product2.setPrice(800.0);

        Product product3 = new Product();
        product3.setTitle("Iphone 13");
        product3.setSubtitle("Black 256gb");
        product3.setDescription("13 256gb BLACK 2022");
        product3.setAvailableQuantity(20);
        product3.setSoldQuantity(19);
        product3.setOriginalPrice(8000.0);
        product3.setPrice(8800.0);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productDataProvider.saveProductList(productList);

    }
}
