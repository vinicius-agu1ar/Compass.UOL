package br.com.compass.partidos.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;

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

import br.com.compass.partidos.dto.request.AssociadoRequestDTO;
import br.com.compass.partidos.dto.response.AssociadoResponseDTO;
import br.com.compass.partidos.dto.response.AssociadoResponseParameters;
import br.com.compass.partidos.enums.CargoPolitico;
import br.com.compass.partidos.enums.Sexo;
import br.com.compass.partidos.services.AssociadoService;
import br.com.compass.partidos.utils.TestUtils;

@WebMvcTest(controllers = AssociadoController.class)
public class AssociadoControllerTest {

    public static final String BASE_URL = "/associados";
    public static final String ID_URL = BASE_URL + "/1";
    public static final Long ID = 1L;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AssociadoService associadoService;

    @Test
    void create() throws Exception {
        AssociadoRequestDTO request = getAssociadoRequestDTO();
        AssociadoResponseDTO associadoResponseDTO = new AssociadoResponseDTO();

        when(associadoService.create(any())).thenReturn(associadoResponseDTO);

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
        AssociadoResponseParameters associadoResponseParameters = new AssociadoResponseParameters();

        when(associadoService.findAll(any(), any())).thenReturn(associadoResponseParameters);

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
        AssociadoResponseDTO associadoResponseDTO = new AssociadoResponseDTO();

        when(associadoService.findById(any())).thenReturn(associadoResponseDTO);

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
        AssociadoRequestDTO request = getAssociadoRequestDTO();
        AssociadoResponseDTO associadoResponseDTO = new AssociadoResponseDTO();

        when(associadoService.update(any(), any())).thenReturn(associadoResponseDTO);

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

    private AssociadoRequestDTO getAssociadoRequestDTO() {
        return AssociadoRequestDTO.builder()
                .nome("Test")
                .cargoPolitico(CargoPolitico.DEPUTADO_ESTADUAL)
                .dataNascimento(LocalDate.of(1993, Month.MAY, 20))
                .sexo(Sexo.FEMININO)
                .build();
    }
    
}
