package com.br.shopcar.Controller;

import com.br.shopcar.Dto.GET.AnnouncementDto;
import com.br.shopcar.Service.AnnouncementService;
import com.br.shopcar.tests.FactoryAnnouncement;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnnouncementController.class)
public class TestControllerAnnouncement {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnnouncementService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Long existingId;
    private Long notExistingId;
    private AnnouncementDto announcementDto;

    private List<AnnouncementDto> announcementDtoList;

    public TestControllerAnnouncement() {
    }

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        notExistingId = 1000L;
        announcementDto = FactoryAnnouncement.createAnnouncementDto();

        when(service.findAll()).thenReturn(announcementDtoList);

        when(service.findById(existingId)).thenReturn(announcementDto);
        when(service.findById(notExistingId)).thenThrow(EntityNotFoundException.class);

        when(service.save(announcementDto)).thenReturn(announcementDto);

        when(service.change(existingId, announcementDto)).thenReturn(announcementDto);
        when(service.change(notExistingId, announcementDto)).thenThrow(EntityNotFoundException.class);

        Mockito.doNothing().when(service).delete(existingId);
        Mockito.doThrow(EntityNotFoundException.class).when(service).delete(notExistingId);

        when(service.findByIdModel(existingId)).thenReturn(announcementDto.convertToModel());
        when(service.findByIdModel(notExistingId)).thenThrow(EntityNotFoundException.class);
    }

    @Test
    void findAll_ShouldReturnOkStatus() throws Exception {
        ResultActions result = mockMvc
                .perform(get("/api/v1/announce")
                .accept(MediaType.APPLICATION_JSON));
            result.andExpect(status().isOk());
    }

    @Test
    void findById_ShouldReturnAnnouncementDto_WhenIdExists() throws Exception {
        ResultActions result = mockMvc
                .perform(get("/api/v1/announce/{id}", this.existingId)
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.user").exists());
        result.andExpect(jsonPath("$.amount").exists());
        result.andExpect(jsonPath("$.date").exists());
    }

    @Test
    void findById_ShouldReturnAnnouncementDto_WhenIdDoesNotExists() throws Exception {
        ResultActions result = mockMvc
                .perform(get("/api/v1/announce/{id}", this.notExistingId)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
        result.andExpect(jsonPath("$.id").doesNotExist());
        result.andExpect(jsonPath("$.user").doesNotExist());
        result.andExpect(jsonPath("$.amount").doesNotExist());
        result.andExpect(jsonPath("$.date").doesNotExist());
    }

    @Test
    void save_ShouldReturnCreatedStatus() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(announcementDto);
        ResultActions result = mockMvc
                .perform(post("/api/v1/announce")
                    .content(jsonBody)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isCreated());

        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.user").exists());
        result.andExpect(jsonPath("$.amount").exists());
        result.andExpect(jsonPath("$.date").exists());
    }

    @Test
    void change_ShouldReturnOkStatus_WhenIdExists() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(announcementDto);
        ResultActions result = mockMvc
                .perform(put("/api/v1/announce/{id}", this.existingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());

        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.user").exists());
        result.andExpect(jsonPath("$.amount").exists());
        result.andExpect(jsonPath("$.date").exists());
    }

    @Test
    void change_ShouldReturnBadRequestStatus_WhenIdDoesNotExists() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(announcementDto);
        ResultActions result = mockMvc
                .perform(put("/api/v1/announce/{id}", this.notExistingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isBadRequest());

        result.andExpect(jsonPath("$.id").doesNotExist());
        result.andExpect(jsonPath("$.user").doesNotExist());
        result.andExpect(jsonPath("$.amount").doesNotExist());
        result.andExpect(jsonPath("$.date").doesNotExist());
    }

    @Test
    void delete_ShouldReturnNoContentStatus_WhenIdExists() throws Exception {
        ResultActions result = mockMvc
                .perform(delete("/api/v1/announce/{id}", this.existingId)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNoContent());

        result.andExpect(jsonPath("$.id").doesNotExist());
        result.andExpect(jsonPath("$.user").doesNotExist());
        result.andExpect(jsonPath("$.amount").doesNotExist());
        result.andExpect(jsonPath("$.date").doesNotExist());
    }

    @Test
    void delete_ShouldReturnBadRequestStatus_WhenIdDoesNotExists() throws Exception {
        ResultActions result = mockMvc
                .perform(put("/api/v1/announce/{id}", this.existingId)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isBadRequest());

        result.andExpect(jsonPath("$.id").doesNotExist());
        result.andExpect(jsonPath("$.user").doesNotExist());
        result.andExpect(jsonPath("$.amount").doesNotExist());
        result.andExpect(jsonPath("$.date").doesNotExist());
    }

}
