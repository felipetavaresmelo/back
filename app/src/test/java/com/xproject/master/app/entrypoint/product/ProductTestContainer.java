package com.xproject.master.app.entrypoint.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xproject.master.app.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@Transactional
@AutoConfigureMockMvc
public class ProductTestContainer {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private Long existingId;
    private Long existingId2;
    private Long nonExistingId;
    private ProductDto productDto1;
    private ProductDto productDto2;

    @BeforeEach
    void setUp() {
        existingId = 1L;
        existingId2 = 4L;
        nonExistingId = 1000L;
        productDto1 = new ProductDto();
        productDto2 = new ProductDto();

        productDto1.setTitle("Smart TV-TC");
        productDto1.setSubtitle("50pol");
        productDto1.setDescription("Samsung UTL5000 2012");
        productDto1.setAvailableQuantity(2);
        productDto1.setSoldQuantity(1);
        productDto1.setOriginalPrice(1500.0);
        productDto1.setPrice(1700.0);


        productDto2.setId(existingId);
        productDto2.setTitle("Apple TV-TC");
        productDto2.setSubtitle("4k");
        productDto2.setDescription("Apple TV 4k HDMI");
        productDto2.setAvailableQuantity(50);
        productDto2.setSoldQuantity(4);
        productDto2.setOriginalPrice(700.0);
        productDto2.setPrice(800.0);

        MockitoAnnotations.openMocks(this);
    }
    @Test
    @DisplayName("Create should return Status 201(Created) and Product")
    void saveProductShouldReturnStatusCreatedWhenValidData() throws Exception{

        String jsonBody = objectMapper.writeValueAsString(productDto1);
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.post("/product/")
                       .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(existingId2));
    }
    @Test
    @DisplayName("Find should return Product And Status 200(Ok) when id exists")
    void findByIdProductShouldReturnStatusOkWhenValidData() throws Exception{
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.get("/product/{$id}", existingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(existingId));
    }
    @Test
    @DisplayName("Find should return NotFound 404 when id does not exists")
    void findByIdProductShouldReturnNotFoundWhenIdDoesNotExists() throws Exception{
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.get("/product/{$id}", nonExistingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Find All should return List And Status 200(Ok)")
    void findAllProductShouldReturnStatusOkWhenValidData() throws Exception{

        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.get("/product/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
    }
    @Test
    @DisplayName("Delete should return Status 200 (Ok) When id exists")
    void deleteProductShouldReturnStatusOkWhenIdExists() throws Exception{
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.delete("/product/{$id}", existingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());

    }
    @Test
    @DisplayName("Delete should return NotFound when Id does not exists")
    void deleteProductShouldReturnNotfoundWhenIdDoesNotExists() throws Exception{
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.delete("/product/{$id}", nonExistingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
    }
    @Test
    @DisplayName("Update should return Status 200(Ok) and Product")
    void updateProductShouldReturnStatusOkWhenValidData() throws Exception{

        String jsonBody = objectMapper.writeValueAsString(productDto2);
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.put("/product/{$id}", existingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(existingId))
                .andExpect(jsonPath("$.title").value(productDto2.getTitle()))
                .andExpect(jsonPath("$.subtitle").value(productDto2.getSubtitle()));
    }
    @Test
    @DisplayName("Update should NotFound 404 when Id does not exists")
    void updateProductShouldReturnNotFoundWhenIdDoesNotExists() throws Exception{

        String jsonBody = objectMapper.writeValueAsString(productDto2);
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.put("/product/{$id}", nonExistingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
    }


}
