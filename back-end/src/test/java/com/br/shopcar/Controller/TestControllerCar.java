package com.br.shopcar.Controller;

import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.br.shopcar.Dto.GET.CarDto;
import com.br.shopcar.Service.CarService;
import com.br.shopcar.tests.FactoryCar;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CarController.class)
public class TestControllerCar {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Long existingId;
    private Long notExistingId;
    private CarDto carDto;

    private List<CarDto> carDtoList;

    public TestControllerCar() {
        
    }

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        notExistingId = 1000L;
        carDto = FactoryCar.createCarDto();

        when(service.findAll()).thenReturn(carDtoList);

        when(service.findById(existingId)).thenReturn(carDto);
        when(service.findById(notExistingId)).thenThrow(EntityNotFoundException.class);

        when(service.save(carDto)).thenReturn(carDto);

        when(service.change(existingId, carDto)).thenReturn(carDto);
        when(service.change(notExistingId, carDto)).thenThrow(EntityNotFoundException.class);

        Mockito.doNothing().when(service).delete(existingId);
        Mockito.doThrow(EntityNotFoundException.class).when(service).delete(notExistingId);

        when(service.findByIdModel(existingId)).thenReturn(carDto.convertToModel());
        when(service.findByIdModel(notExistingId)).thenThrow(EntityNotFoundException.class);
    }

    @Test
    void findAll_shouldReturnOkStatus() throws Exception {
        ResultActions result = mockMvc
        .perform(get("/cars")
        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
    }

    @Test
    void findById_shouldReturnCarDto_whenIdExists() throws Exception {
        ResultActions result = mockMvc
        .perform(get("/cars/{id}", this.existingId)
        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.nome").exists());
        result.andExpect(jsonPath("$.descricao").exists());
        result.andExpect(jsonPath("$.preco").exists());
        result.andExpect(jsonPath("$.quilometragem").exists());
        result.andExpect(jsonPath("$.modelo").exists());
    }

    @Test
    void findById_ShouldReturnNotFoundStatus_WhenIdDoesNotExists() throws Exception {
        ResultActions result = mockMvc
        .perform(get("/cars/{id}", this.notExistingId)
        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
        result.andExpect(jsonPath("$.id").doesNotExist());
        result.andExpect(jsonPath("$.nome").doesNotExist());
        result.andExpect(jsonPath("$.descricao").doesNotExist());
        result.andExpect(jsonPath("$.preco").doesNotExist());
        result.andExpect(jsonPath("$.quilometragem").doesNotExist());
        result.andExpect(jsonPath("$.modelo").doesNotExist());
    }

    @Test
    void save_shouldReturnCreatedStatus() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(carDto);

        System.out.println(jsonBody);

        ResultActions result = mockMvc
        .perform(post("/cars")
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated());
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.nome").exists());
        result.andExpect(jsonPath("$.descricao").exists());
        result.andExpect(jsonPath("$.preco").exists());
        result.andExpect(jsonPath("$.quilometragem").exists());
        result.andExpect(jsonPath("$.modelo").exists());
    }

    @Test
    void change_ShouldReturnOkStatus_WhenIdExists() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(carDto);

        ResultActions result = mockMvc
        .perform(put("/cars/{id}", this.existingId)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());

        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.nome").exists());
        result.andExpect(jsonPath("$.descricao").exists());
        result.andExpect(jsonPath("$.preco").exists());
        result.andExpect(jsonPath("$.quilometragem").exists());
        result.andExpect(jsonPath("$.modelo").exists());
    }

    @Test
    void change_ShouldReturnNotFoundStatus_WhenIdDoesNotExists() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(carDto);

        ResultActions result = mockMvc
        .perform(put("/cars/{id}", this.notExistingId)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());

        result.andExpect(jsonPath("$.id").doesNotExist());
        result.andExpect(jsonPath("$.nome").doesNotExist());
        result.andExpect(jsonPath("$.descricao").doesNotExist());
        result.andExpect(jsonPath("$.preco").doesNotExist());
        result.andExpect(jsonPath("$.quilometragem").doesNotExist());
        result.andExpect(jsonPath("$.modelo").doesNotExist());
    }

    @Test
    void delete_ShouldReturnNoContentStatus_WhenIdExists() throws Exception {
        ResultActions result = mockMvc
        .perform(delete("/cars/{id}", this.existingId)
        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNoContent());

        result.andExpect(jsonPath("$.id").doesNotExist());
        result.andExpect(jsonPath("$.nome").doesNotExist());
        result.andExpect(jsonPath("$.descricao").doesNotExist());
        result.andExpect(jsonPath("$.preco").doesNotExist());
        result.andExpect(jsonPath("$.quilometragem").doesNotExist());
        result.andExpect(jsonPath("$.modelo").doesNotExist());
    }

    @Test
    void delete_ShouldReturnBadRequestStatus_WhenIdDoesNotExists() throws Exception {
        ResultActions result = mockMvc
        .perform(put("/cars/{id}", this.existingId)
        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isBadRequest());

        result.andExpect(jsonPath("$.id").doesNotExist());
        result.andExpect(jsonPath("$.nome").doesNotExist());
        result.andExpect(jsonPath("$.descricao").doesNotExist());
        result.andExpect(jsonPath("$.preco").doesNotExist());
        result.andExpect(jsonPath("$.quilometragem").doesNotExist());
        result.andExpect(jsonPath("$.modelo").doesNotExist());
    }

}