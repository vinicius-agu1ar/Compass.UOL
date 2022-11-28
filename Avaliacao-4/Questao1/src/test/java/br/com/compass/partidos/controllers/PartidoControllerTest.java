package br.com.compass.partidos.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.compass.partidos.dto.request.PartidoRequestDTO;
import br.com.compass.partidos.dto.response.PartidoResponseDTO;
import br.com.compass.partidos.dto.response.PartidoResponseParameters;
import br.com.compass.partidos.enums.Ideologia;
import br.com.compass.partidos.services.PartidoService;
import br.com.compass.partidos.utils.TestUtils;

@WebMvcTest(controllers = PartidoController.class)
public class PartidoControllerTest {
    
    public static final String BASE_URL = "/partidos";
    public static final String ID_URL = BASE_URL + "/1";
    public static final Long ID = 1L;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PartidoService partidoService;

    @Test
    void create() throws Exception {
        PartidoRequestDTO request = getPartidoRequestDTO();
        PartidoResponseDTO partidoResponseDTO = new PartidoResponseDTO();

        when(partidoService.create(any())).thenReturn(partidoResponseDTO);

        String input = TestUtils.mapToJson(request);

        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.post(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    void findAll() throws Exception {
        PartidoResponseParameters partidoResponseParameters = new PartidoResponseParameters();

        when(partidoService.findAll(any(), any())).thenReturn(partidoResponseParameters);

        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void findById() throws Exception {
        PartidoResponseDTO partidoResponseDTO = new PartidoResponseDTO();

        when(partidoService.findById(any())).thenReturn(partidoResponseDTO);

        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get(ID_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void update() throws Exception {
        PartidoRequestDTO request = getPartidoRequestDTO();
        PartidoResponseDTO partidoResponseDTO = new PartidoResponseDTO();

        when(partidoService.update(any(), any())).thenReturn(partidoResponseDTO);

        String input = TestUtils.mapToJson(request);

        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.put(ID_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void delete() throws Exception {
        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.delete(ID_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
    }

    private PartidoRequestDTO getPartidoRequestDTO() {
        return PartidoRequestDTO.builder()
                .nome("Test")
                .sigla("Sigla")
                .ideologia(Ideologia.CENTRO)
                .dataFundacao(LocalDateTime.now())
                .build();
    }
}
