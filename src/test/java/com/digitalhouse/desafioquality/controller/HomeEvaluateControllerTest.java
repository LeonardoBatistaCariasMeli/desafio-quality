package com.digitalhouse.desafioquality.controller;

import com.digitalhouse.desafioquality.utils.TestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeEvaluateControllerTest {
    private final String REQUEST_VALID = TestUtils.getValidRequest();
    private final String REQUEST_INVALID = TestUtils.getInvalidRequest();

    @Autowired
    private MockMvc mockMvc;

    public HomeEvaluateControllerTest() throws JsonProcessingException {
    }

    @Test
    public void shouldCalculatePropertySquareMetersValidRequest() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/square-meters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(REQUEST_VALID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.squareMeters").value(69.0));
    }

    @Test
    public void shouldCalculatePropertySquareMetersInvalidRequest() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/square-meters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(REQUEST_INVALID))
                .andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldCalculatePropertySquareMetersInvalidRequestWithoutBody() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/square-meters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldCalculatePropertyPriceValidRequest() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/property-price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(REQUEST_VALID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.propertyPrice").value(6900.0));
    }

    @Test
    public void shouldCalculatePropertyPriceInvalidRequest() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/property-price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(REQUEST_INVALID))
                .andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldCalculatePropertyPriceInvalidRequestWithoutBody() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/property-price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldCalculateGreaterRoomValidRequest() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/greater-room")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(REQUEST_VALID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.roomName").value("Sala"));
    }

    @Test
    public void shouldCalculateGreaterRoomInvalidRequest() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/greater-room")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(REQUEST_INVALID))
                .andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldCalculateGreaterRoomInvalidRequestWithoutBody() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/greater-room")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldCalculateEachRoomsSquareMetersValidRequest() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/square-meters-rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(REQUEST_VALID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].squareMeters").value(24.0))
                .andExpect(jsonPath("$[1].squareMeters").value(35.0))
                .andExpect(jsonPath("$[2].squareMeters").value(10.0));
    }

    @Test
    public void shouldCalculateEachRoomsSquareMetersInvalidRequest() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/square-meters-rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(REQUEST_INVALID))
                .andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldCalculateEachRoomsSquareMetersInvalidRequestWithoutBody() throws Exception {
        this.mockMvc.perform(
                post("/home-evaluate/square-meters-rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print()).andExpect(status().isBadRequest());
    }
}
