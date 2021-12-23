package com.xproject.master.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.xproject.master.app.entrypoint.ClientRestController",
		"com.xproject.master.app.entrypoint.ProductRestController",
		"com.xproject.master.app.entrypoint.IndexController"})
//@EntityScan("com.xproject.master.domain.entity")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
