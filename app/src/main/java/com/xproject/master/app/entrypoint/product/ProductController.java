package com.xproject.master.app.entrypoint.product;

import com.xproject.master.app.dto.ClientDto;
import com.xproject.master.app.dto.ProductDto;
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

public interface ProductController extends ApiInfo {

    @Operation(summary = "Busca de produto pelo id",
            parameters = {
                    @Parameter(
                            schema = @Schema(
                                    implementation = Integer.class
                            ),
                            name = "id", description = "Id do produto", required = true, in = ParameterIn.PATH),
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
                                                            "  \"id\": 0,\n" +
                                                            "  \"title\": \"string\",\n" +
                                                            "  \"subtitle\": \"string\",\n" +
                                                            "  \"description\": \"string\",\n" +
                                                            "  \"availableQuantity\": 0,\n" +
                                                            "  \"soldQuantity\": 0,\n" +
                                                            "  \"originalPrice\": 0,\n" +
                                                            "  \"price\": 0\n" +
                                                            "}"
                                            )
                                    })
                    ),
                    @ApiResponse(responseCode = "408", description = "Quando uma requisição interna falha devido a timeout",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "500", description = "Quando acontece um erro interno",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "502", description = "Quando alguma requisição retorna null",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class)))
            }
    )
    ResponseEntity<ProductDto> findProductById(Long id);
    @Operation(summary = "Busca de todos os produtos",
            parameters = {},
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Sucesso",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "Cenário Sucesso",
                                                    value = "[\n" +
                                                            "  {\n" +
                                                            "    \"id\": 1,\n" +
                                                            "    \"title\": \"Smart TV\",\n" +
                                                            "    \"subtitle\": \"50pol\",\n" +
                                                            "    \"description\": \"Samsung UTL5000 2012\",\n" +
                                                            "    \"availableQuantity\": 2,\n" +
                                                            "    \"soldQuantity\": 1,\n" +
                                                            "    \"originalPrice\": 1500,\n" +
                                                            "    \"price\": 1700\n" +
                                                            "  },\n" +
                                                            "  {\n" +
                                                            "    \"id\": 2,\n" +
                                                            "    \"title\": \"Apple TV\",\n" +
                                                            "    \"subtitle\": \"4k\",\n" +
                                                            "    \"description\": \"Apple TV 4k HDMI\",\n" +
                                                            "    \"availableQuantity\": 50,\n" +
                                                            "    \"soldQuantity\": 4,\n" +
                                                            "    \"originalPrice\": 700,\n" +
                                                            "    \"price\": 800\n" +
                                                            "  }\n" +
                                                            "]"
                                            )
                                    })
                    ),
                    @ApiResponse(responseCode = "408", description = "Quando uma requisição interna falha devido a timeout",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "500", description = "Quando acontece um erro interno",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "502", description = "Quando alguma requisição retorna null",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class)))
            }
    )
    ResponseEntity<List<ProductDto>> findProductAll();
    @Operation(summary = "Criar um novo produto.",

            responses = {
                    @ApiResponse(
                            responseCode = "201", description = "Sucesso",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "Cenário Sucesso",
                                                    value = "  {\n" +
                                                            "    \"id\": 1,\n" +
                                                            "    \"title\": \"Smart TV\",\n" +
                                                            "    \"subtitle\": \"50pol\",\n" +
                                                            "    \"description\": \"Samsung UTL5000 2012\",\n" +
                                                            "    \"availableQuantity\": 2,\n" +
                                                            "    \"soldQuantity\": 1,\n" +
                                                            "    \"originalPrice\": 1500,\n" +
                                                            "    \"price\": 1700\n" +
                                                            "  }\n"

                                            )
                                    })
                    ),
                    @ApiResponse(responseCode = "408", description = "Quando uma requisição interna falha devido a timeout",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "500", description = "Quando acontece um erro interno",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "502", description = "Quando alguma requisição retorna null",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class)))
            }
    )
    ResponseEntity<ProductDto> createProduct(ProductDto productDTO);
    @Operation(summary = "Criar uma lista de novos produtos.",

            responses = {
                    @ApiResponse(
                            responseCode = "201", description = "Sucesso",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "Cenário Sucesso",
                                                    value = "[\n" +
                                                            "  {\n" +
                                                            "    \"id\": 1,\n" +
                                                            "    \"title\": \"Smart TV\",\n" +
                                                            "    \"subtitle\": \"50pol\",\n" +
                                                            "    \"description\": \"Samsung UTL5000 2012\",\n" +
                                                            "    \"availableQuantity\": 2,\n" +
                                                            "    \"soldQuantity\": 1,\n" +
                                                            "    \"originalPrice\": 1500,\n" +
                                                            "    \"price\": 1700\n" +
                                                            "  }\n" +
                                                            "]"
                                            )
                                    })
                    ),
                    @ApiResponse(responseCode = "408", description = "Quando uma requisição interna falha devido a timeout",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "500", description = "Quando acontece um erro interno",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "502", description = "Quando alguma requisição retorna null",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class)))
            }
    )
    ResponseEntity<List<ProductDto>> createProductList(List<ProductDto> productDtoList);

    @Operation(summary = "Atualiza um produto.",
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
                                                    value = "  {\n" +
                                                            "    \"id\": 1,\n" +
                                                            "    \"title\": \"Smart TV\",\n" +
                                                            "    \"subtitle\": \"50pol\",\n" +
                                                            "    \"description\": \"Samsung UTL5000 2012\",\n" +
                                                            "    \"availableQuantity\": 2,\n" +
                                                            "    \"soldQuantity\": 1,\n" +
                                                            "    \"originalPrice\": 1500,\n" +
                                                            "    \"price\": 1700\n" +
                                                            "  }\n"
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
    ResponseEntity<ProductDto> updateProduct(Long id, ProductDto productDTO);

    @Operation(summary = "Remove produto pelo id",
            parameters = {
                    @Parameter(
                            schema = @Schema(
                                    implementation = Integer.class
                            ),
                            name = "id", description = "Id do produto", required = true, in = ParameterIn.PATH),
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
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "500", description = "Quando acontece um erro interno",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "502", description = "Quando alguma requisição retorna null",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class)))
            }
    )
    ResponseEntity<Void> deleteProductById(Long id);
    @Operation(summary = "Remove uma lista de novos produtos.",

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
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "500", description = "Quando acontece um erro interno",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "502", description = "Quando alguma requisição retorna null",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProductDto.class)))
            }
    )
    ResponseEntity<Void> deleteProductList(List<ProductDto> productDtoList);

}
