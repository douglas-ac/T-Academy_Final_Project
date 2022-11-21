package com.br.shopcar.Controller;

import com.br.shopcar.Dto.GET.LoginDto;
import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService service;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldReturnOkToGetAllUsers() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/v1/user")
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOneUserWithId() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/v1/user/1")
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
    }

    @Test
    public void shouldThownAnUserNotFoundExceptionWhenIdNoExist() throws Exception {
                mockMvc.perform(get("/api/v1/user/99")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException))
                .andExpect(result -> assertEquals("User not found", result.getResolvedException().getMessage()));
    }

    @Test
    public void shouldReturnCreatedOnPostANewUser() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setName("Mario Bezerra");
        userDto.setFone("77988589023");
        userDto.setEmail("mario@gmail.com");
        userDto.setLogin(new LoginDto("mariozin", "123456"));
        userDto.setBirthDate("05-03-1999");
        userDto.setNacionalNumber("05896515455");
        userDto.setDescriminationColumn("CPF");

        String usuarioString = objectMapper.writeValueAsString(userDto);

        ResultActions result = mockMvc.perform(post("/api/v1/user")
                .content(usuarioString)
                .contentType(MediaType.APPLICATION_JSON));
        result.andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnTheDtoOfTheUserWithTheUpdates() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setName("Teste teste");
        userDto.setFone("77988589023");
        userDto.setEmail("mario@gmail.com");
        userDto.setLogin(new LoginDto("mariozin", "123456"));
        userDto.setBirthDate("05-03-1999");
        userDto.setNacionalNumber("05896515455");
        userDto.setDescriminationColumn("CPF");

        String usuarioString = objectMapper.writeValueAsString(userDto);

        ResultActions result = mockMvc.perform(put("/api/v1/user/1")
                .content(usuarioString)
                .contentType(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.name").exists());
        result.andExpect(jsonPath("$.name").value("Teste teste"));
        result.andExpect(jsonPath("$.email").value("mario@gmail.com"));
        result.andExpect(jsonPath("$.birthDate").value("05-03-1999"));
        result.andExpect(jsonPath("$.nacionalNumber").value("05896515455"));

    }

    @Test
    public void shouldReturnNoContentOnDelete() throws Exception {
        ResultActions result =
                mockMvc.perform(delete("/api/v1/user/{idUser}", 3L));
        result.andExpect(status().isNoContent());
    }

}
