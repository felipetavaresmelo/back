package com.xproject.master.app.entrypoint;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info =
@Info(title = "X-Project"
        , description = "This project was made using Clean Archiquecture."
        , version = "0.0.1"),
        servers = {
                @Server(url = "http://localhost:8080/", description = "Enviromment Local"),
                @Server(url = "http://10.10.10.10:8080/", description = "Enviromment Remoto")
        })
public interface ApiInfo {
}