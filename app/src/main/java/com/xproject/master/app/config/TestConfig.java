package com.xproject.master.app.config;

import com.xproject.master.app.dataprovider.ClientDataProviderImpl;
import com.xproject.master.domain.entity.client.Client;
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

    }
}
