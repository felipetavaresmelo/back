package com.xproject.master.app.config;

import com.xproject.master.app.dataprovider.ClientDataProviderImpl;
import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
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

        List<ClientPO> clientPOList = new ArrayList<>();

        ClientPO clientPO1 = new ClientPO();
        clientPO1.setName("Antonio Silva");
        clientPO1.setPhone("988888888");
        clientPOList.add(clientPO1);

        ClientPO clientPO2 = new ClientPO();
        clientPO2.setName("Alexandre Verde");
        clientPO2.setPhone("977777777");
        clientPOList.add(clientPO2);

        clientDataProvider.saveClientPOList(clientPOList);

        List<Client> clientList = new ArrayList<>();

        Client client = new Client();
        client.setName("Maria Brown");
        client.setPhone("988888888");
        clientList.add(client);

        Client client2 = new Client();
        client2.setName("Alex Green");
        client2.setPhone("977777777");
        clientList.add(client2);

        clientDataProvider.saveClientList(clientList);

    }
}
