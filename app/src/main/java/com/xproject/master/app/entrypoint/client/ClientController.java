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
                                                            "  \"id\": 2,\n" +
                                                            "  \"name\": \"Joao\",\n" +
                                                            "  \"phone\": \"1230982\"\n" +
                                                            "}"
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

    @Operation(summary = "Busca de todos os clientes",

            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Sucesso",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "Cenário Sucesso",
                                                    value =
                                                            "[\n" +
                                                                    "  {\n" +
                                                                    "    \"id\": 2,\n" +
                                                                    "    \"name\": \"Joao\",\n" +
                                                                    "    \"phone\": \"120398123\"\n" +
                                                                    "  },{\n" +
                                                                    "    \"id\": 3,\n" +
                                                                    "    \"name\": \"Maria\",\n" +
                                                                    "    \"phone\": \"120398123\"\n" +
                                                                    "  }\n" +
                                                                    "]"
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
    ResponseEntity<List<ClientDto>> findClientAll();

    @Operation(summary = "Criar um novo cliente.",

            responses = {
                    @ApiResponse(
                            responseCode = "201", description = "Sucesso",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "Cenário Sucesso",
                                                    value = "{\n" +
                                                            "  \"id\": 2,\n" +
                                                            "  \"name\": \"Joao\",\n" +
                                                            "  \"phone\": \"1230982\"\n" +
                                                            "}"
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
    ResponseEntity<ClientDto> createClient(ClientDto clientDTO);

    @Operation(summary = "Criar uma lista de novos clientes.",

            responses = {
                    @ApiResponse(
                            responseCode = "201", description = "Sucesso",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "Cenário Sucesso",
                                                    value =
                                                            "[\n" +
                                                                    "  {\n" +
                                                                    "    \"id\": 2,\n" +
                                                                    "    \"name\": \"Joao\",\n" +
                                                                    "    \"phone\": \"120398123\"\n" +
                                                                    "  },{\n" +
                                                                    "    \"id\": 3,\n" +
                                                                    "    \"name\": \"Maria\",\n" +
                                                                    "    \"phone\": \"120398123\"\n" +
                                                                    "  }\n" +
                                                                    "]"
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
    ResponseEntity<List<ClientDto>> createClientList(List<ClientDto> clientDtoList);

    @Operation(summary = "Atualiza um cliente.",
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
                                                            "  \"id\": 2,\n" +
                                                            "  \"name\": \"Joao\",\n" +
                                                            "  \"phone\": \"1230982\"\n" +
                                                            "}"
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
    ResponseEntity<ClientDto> updateClient(Long id, ClientDto clientDTO);
    @Operation(summary = "Remove cliente pelo id",
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
                                                    value = " "
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
    ResponseEntity<Void> deleteClientById(Long id);
    @Operation(summary = "Remove uma lista de novos clientes.",

            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Sucesso",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "Cenário Sucesso",
                                                    value =
                                                            "[\n" +
                                                                    "  {\n" +
                                                                    "    \"id\": 2\n" +
                                                                    "  },{\n" +
                                                                    "    \"id\": 3\n" +
                                                                    "  }\n" +
                                                                    "]"
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
    ResponseEntity<Void> deleteClientList(List<ClientDto> clientDtoList);
}