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

        ClientPO c1 = ClientPO.builder().id(1L).name("Maria Brown").phone("988888888").build();
        ClientPO c2 = ClientPO.builder().id(2L).name("Alex Green").phone("977777777").build();

        clientJpaRepository.saveAll(Arrays.asList(c1, c2));
    }
}
