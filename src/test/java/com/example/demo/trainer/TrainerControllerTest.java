package com.example.demo.trainer;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class TrainerControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void statusIsOkWhenPostCall() throws Exception {
        //given
        TrainerDTO trainerDTO = new TrainerDTO();
        String trainerName = "imie";
        trainerDTO.setName(trainerName);
        String trainerSurname = "nazwisko";
        trainerDTO.setSurname(trainerSurname);
        long trainerPesel = 12345678768L;
        trainerDTO.setPesel(trainerPesel);

        mockMvc.perform(post("/trainer").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(trainerDTO))).andExpect(status().isOk());

        MvcResult result = mockMvc.perform(get("/trainer"))
                .andExpect(status().isOk())
                .andReturn();

        List<TrainerDTO> actual = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });

        assertEquals(actual.get(0).getName(), trainerName);
        assertEquals(actual.get(0).getSurname(), trainerSurname);
        assertEquals(actual.get(0).getPesel(), trainerPesel);
    }

    @Test
    public void shouldTheSameTrainerIsNotAdded() throws Exception {
        //given
        TrainerDTO trener1 = new TrainerDTO("imie", "nazwisko", 12345678768L);
        TrainerDTO trener2 = new TrainerDTO("imie2", "nazwisko2", 12345678768L);

        mockMvc.perform(post("/trainer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper()
                        .writeValueAsString(trener1)))
                .andExpect(status().isOk());
        //expect
        mockMvc.perform(post("/trainer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper()
                        .writeValueAsString(trener2)))
                .andExpect(status().isConflict());
    }


}