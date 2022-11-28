package br.com.compass.partidos.services;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.compass.partidos.dto.request.PartidoRequestDTO;
import br.com.compass.partidos.dto.response.PartidoResponseDTO;
import br.com.compass.partidos.dto.response.PartidoResponseParameters;
import br.com.compass.partidos.entities.PartidoEntity;
import br.com.compass.partidos.exceptions.PartidoNotFoundException;
import br.com.compass.partidos.repositories.PartidoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PartidoServiceTest {
    
    public static final Long ID = 1L;

    @InjectMocks
    private PartidoService partidoService;

    @Mock
    private PartidoRepository partidoRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void shouldCreatePartido_success() {
        PartidoEntity partido = new PartidoEntity();
        PartidoResponseDTO response = new PartidoResponseDTO();
        PartidoRequestDTO request = new PartidoRequestDTO();

        Mockito.when(modelMapper.map(any(), eq(PartidoEntity.class))).thenReturn(partido);
        Mockito.when(partidoRepository.save(any())).thenReturn(partido);
        Mockito.when(modelMapper.map(any(), eq(PartidoResponseDTO.class))).thenReturn(response);

        PartidoResponseDTO partidoResponseDTO = partidoService.create(request);

        assertEquals(response, partidoResponseDTO);
        verify(partidoRepository).save(any());
    }

    @Test
    void shouldUpdatePartido_success() {
        PartidoEntity partido = new PartidoEntity();
        PartidoResponseDTO response = new PartidoResponseDTO();
        PartidoRequestDTO request = new PartidoRequestDTO();

        Mockito.when(partidoRepository.findById(any())).thenReturn(Optional.of(partido));
        Mockito.when(modelMapper.map(any(), eq(PartidoEntity.class))).thenReturn(partido);
        Mockito.when(partidoRepository.save(any())).thenReturn(partido);
        Mockito.when(modelMapper.map(any(), eq(PartidoResponseDTO.class))).thenReturn(response);

        PartidoResponseDTO partidoResponseDTO = partidoService.update(ID, request);

        assertEquals(response, partidoResponseDTO);
        verify(partidoRepository).save(any());
    }

    @Test
    void shouldUpdatePartido_error_notFound() {
        PartidoRequestDTO request = new PartidoRequestDTO();

        Mockito.when(partidoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(PartidoNotFoundException.class, () -> partidoService.update(ID, request));
    }

    @Test
    void shouldDeletePartido_success() {
        PartidoEntity partido = new PartidoEntity();

        Mockito.when(partidoRepository.findById(any())).thenReturn(Optional.of(partido));

        partidoService.delete(ID);

        verify(partidoRepository).deleteById(any());
    }

    @Test
    void shouldFindPartidoById_success() {
        PartidoEntity partido = new PartidoEntity();
        PartidoResponseDTO response = new PartidoResponseDTO();

        Mockito.when(partidoRepository.findById(any())).thenReturn(Optional.of(partido));
        Mockito.when(modelMapper.map(any(), eq(PartidoResponseDTO.class))).thenReturn(response);

        PartidoResponseDTO partidoResponseDTO = partidoService.findById(ID);

        assertEquals(response, partidoResponseDTO);
    }

    @Test
    void shouldFindAllPartidos_success() {
        PartidoEntity partido = new PartidoEntity();
        PartidoResponseDTO response = new PartidoResponseDTO();
        Page<PartidoEntity> page = new PageImpl<>(List.of(partido));
        PartidoResponseParameters expectedPartidoResponseParameters = getPartidoResponseParameters();

        Mockito.when(partidoRepository.findAll((Pageable) any())).thenReturn(page);
        Mockito.when(modelMapper.map(any(), eq(PartidoResponseDTO.class))).thenReturn(response);

        PartidoResponseParameters partidoResponseParameters = partidoService.findAll(null, any(Pageable.class));

        assertEquals(expectedPartidoResponseParameters, partidoResponseParameters);
    }

    private PartidoResponseParameters getPartidoResponseParameters() {
        return PartidoResponseParameters.builder()
                .numberOfElements(1)
                .totalElements(1L)
                .totalPages(1)
                .partido(List.of(new PartidoResponseDTO()))
                .build();
    }
}
