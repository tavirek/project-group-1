package com.example.demo.contollers;

import com.example.demo.trainer.TrainerDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TrainerControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void statusIsOkWhenPostCall() throws Exception {
        //given
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setName("imie");
        trainerDTO.setSurname("nazwisko");
        trainerDTO.setPesel((long) 1234567876);

        mockMvc.perform(post("/trainer").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(trainerDTO))).andExpect(status().isOk());

        MvcResult result = mockMvc.perform(get("/trainer"))
                .andExpect(status().isOk())
                .andReturn();

        List<TrainerDTO> actual = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<TrainerDTO>>() {
        });

        assertEquals(actual.get(0).getName(), "imie");
        assertEquals(actual.get(0).getSurname(), "nazwisko");
        assertEquals(actual.get(0).getPesel(), 1234567876);
    }
}