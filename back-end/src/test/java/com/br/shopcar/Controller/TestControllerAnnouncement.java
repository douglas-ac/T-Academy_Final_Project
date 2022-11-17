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
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;


import javax.servlet.ServletContext;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        notExistingId = 1000L;
        announcementDto = FactoryAnnouncement.createAnnouncementDto();

        when(service.findAll()).thenReturn((List<AnnouncementDto>) announcementDto);

        when(service.findById(existingId)).thenReturn(announcementDto);
        when(service.findById(notExistingId)).thenThrow(Exception.class);

        when(service.save(announcementDto)).thenReturn(announcementDto);

        when(service.change(existingId, announcementDto)).thenReturn(announcementDto);
        when(service.change(notExistingId, announcementDto)).thenThrow(Exception.class);

        Mockito.doNothing().when(service).delete(existingId);
        Mockito.doThrow(Exception.class).when(service).delete(notExistingId);

        when(service.findByIdModel(existingId)).thenReturn(announcementDto.convertToModel());
        when(service.findByIdModel(notExistingId)).thenThrow(Exception.class);
    }

    @Test
    void findAll_ShouldReturnAnnouncementDtoList() throws Exception {
        ResultActions result = mockMvc
                .perform(get("api/v1/announce")
                .accept(MediaType.APPLICATION_JSON));
            result.andExpect(status().isOk());
    }

    @Test
    void findById_ShouldReturnAnnouncementDto_WhenIdExists() throws Exception {
        ResultActions result = mockMvc
                .perform(get("api/v1/announce/{id}", this.existingId)
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.user").exists());
        result.andExpect(jsonPath("$.amount").exists());
        result.andExpect(jsonPath("$.date").exists());
    }

    @Test
    void findById_ShouldReturnAnnouncementDto_WhenIdNotExists() throws Exception {
        ResultActions result = mockMvc
                .perform(get("api/v1/announce/{id}", this.notExistingId)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
        result.andExpect(jsonPath("$.id").doesNotExist());
        result.andExpect(jsonPath("$.user").doesNotExist());
        result.andExpect(jsonPath("$.amount").doesNotExist());
        result.andExpect(jsonPath("$.date").doesNotExist());
    }
}
