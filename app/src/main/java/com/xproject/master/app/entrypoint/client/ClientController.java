package com.xproject.master.app.entrypoint.client;

import com.xproject.master.app.dto.ClientDto;
import com.xproject.master.app.entrypoint.ApiInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientController extends ApiInfo {

    @Operation(summary = "Busca de cliente pelo id",
            parameters = {
                    @Parameter(
                            schema = @Schema(
                                    implementation = Integer.class
                            ),
                            name = "id", description = "Id do cliente", required = true, in = ParameterIn.PATH),
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Sucesso",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "Cenário Sucesso",
                                                    value = "{\n" +
                                                            "\"id\": \"1L\"\n" +
                                                            "\"name\": \"teste\"\n" +
                                                            "\"phone\": \"81999999999\"\n" +
                                                            "}\n"
                                            )
                                    })
                    ),
                    @ApiResponse(responseCode = "408", description = "Quando uma requisição interna falha devido a timeout",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class))),
                    @ApiResponse(responseCode = "500", description = "Quando acontece um erro interno",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class))),
                    @ApiResponse(responseCode = "502", description = "Quando alguma requisição retorna null",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class)))
            }
    )
    ResponseEntity<ClientDto> findClientById(Long id);

    ResponseEntity<List<ClientDto>> findClientAll();
    ResponseEntity<ClientDto> createClient(ClientDto clientDTO);
    ResponseEntity<List<ClientDto>> createClientList(List<ClientDto> clientDtoList);
    ResponseEntity<ClientDto> updateClient(Long id, ClientDto clientDTO);
}