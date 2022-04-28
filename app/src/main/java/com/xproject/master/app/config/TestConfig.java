package com.xproject.master.app.config;

import com.xproject.master.app.dataprovider.repositories.ClientJpaRepository;
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
    private ClientJpaRepository clientJpaRepository;

    @Override
    public void run(String... args) {

        ClientPO c1 = new ClientPO(null, "Maria Brown", "988888888");
        ClientPO c2 = new ClientPO(null, "Alex Green", "977777777");

        clientJpaRepository.saveAll(Arrays.asList(c1, c2));
    }
}
