package com.xproject.master.app.entrypoint;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info =
@Info(title = "Título"
        , description = "descrição"
        , version = "1.0.0"),
        servers = {
                @Server(url = "http://localhost:8080/", description = "Enviromment Local"),
                @Server(url = "http://10.10.10.10:8080/", description = "Enviromment Remoto")
        })
public interface ApiInfo {
}