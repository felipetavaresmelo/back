package com.xproject.master.app.config;

import com.xproject.master.app.dataprovider.repositories.ClientRepository;
import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {

        ClientPO clientPO_1 = new ClientPO(null, "Maria Brown", "988888888");
        ClientPO clientPO_2 = new ClientPO(null, "Alex Green", "977777777");

        clientRepository.saveAll(Arrays.asList(clientPO_1, clientPO_2));
    }
}
