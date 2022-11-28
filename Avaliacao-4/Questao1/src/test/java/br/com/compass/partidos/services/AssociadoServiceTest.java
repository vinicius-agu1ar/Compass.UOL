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

import br.com.compass.partidos.dto.request.AssociadoRequestDTO;
import br.com.compass.partidos.dto.response.AssociadoResponseDTO;
import br.com.compass.partidos.dto.response.AssociadoResponseParameters;
import br.com.compass.partidos.entities.AssociadoEntity;
import br.com.compass.partidos.exceptions.AssociadoNotFoundException;
import br.com.compass.partidos.repositories.AssociadoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AssociadoServiceTest {
    
    public static final Long ID = 1L;

    @InjectMocks
    private AssociadoService associadoService;

    @Mock
    private AssociadoRepository associadoRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void shouldCreateAssociado_success() {
        AssociadoEntity associado = new AssociadoEntity();
        AssociadoResponseDTO response = new AssociadoResponseDTO();
        AssociadoRequestDTO request = new AssociadoRequestDTO();

        Mockito.when(modelMapper.map(any(), eq(AssociadoEntity.class))).thenReturn(associado);
        Mockito.when(associadoRepository.save(any())).thenReturn(associado);
        Mockito.when(modelMapper.map(any(), eq(AssociadoResponseDTO.class))).thenReturn(response);

        AssociadoResponseDTO associadoResponseDTO = associadoService.create(request);

        assertEquals(response, associadoResponseDTO);
        verify(associadoRepository).save(any());
    }

    @Test
    void shouldUpdateAssociado_success() {
        AssociadoEntity associado = new AssociadoEntity();
        AssociadoResponseDTO response = new AssociadoResponseDTO();
        AssociadoRequestDTO request = new AssociadoRequestDTO();

        Mockito.when(associadoRepository.findById(any())).thenReturn(Optional.of(associado));
        Mockito.when(modelMapper.map(any(), eq(AssociadoEntity.class))).thenReturn(associado);
        Mockito.when(associadoRepository.save(any())).thenReturn(associado);
        Mockito.when(modelMapper.map(any(), eq(AssociadoResponseDTO.class))).thenReturn(response);

        AssociadoResponseDTO associadoResponseDTO = associadoService.update(ID, request);

        assertEquals(response, associadoResponseDTO);
        verify(associadoRepository).save(any());
    }

    @Test
    void shouldUpdateAssociado_error_notFound() {
        AssociadoRequestDTO request = new AssociadoRequestDTO();

        Mockito.when(associadoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(AssociadoNotFoundException.class, () -> associadoService.update(ID, request));
    }

    @Test
    void shouldDeleteAssociado_success() {
        AssociadoEntity associado = new AssociadoEntity();

        Mockito.when(associadoRepository.findById(any())).thenReturn(Optional.of(associado));

        associadoService.delete(ID);

        verify(associadoRepository).deleteById(any());
    }

    @Test
    void shouldFindAssociadoById_success() {
        AssociadoEntity associado = new AssociadoEntity();
        AssociadoResponseDTO response = new AssociadoResponseDTO();

        Mockito.when(associadoRepository.findById(any())).thenReturn(Optional.of(associado));
        Mockito.when(modelMapper.map(any(), eq(AssociadoResponseDTO.class))).thenReturn(response);

        AssociadoResponseDTO associadoResponseDTO = associadoService.findById(ID);

        assertEquals(response, associadoResponseDTO);
    }

    @Test
    void shouldFindAllAssociado_success() {
        AssociadoEntity associado = new AssociadoEntity();
        AssociadoResponseDTO response = new AssociadoResponseDTO();
        Page<AssociadoEntity> page = new PageImpl<>(List.of(associado));
        AssociadoResponseParameters expectedAssociadoResponseParameters = getAssociadoResponseParameters();

        Mockito.when(associadoRepository.findAll((Pageable) any())).thenReturn(page);
        Mockito.when(modelMapper.map(any(), eq(AssociadoResponseDTO.class))).thenReturn(response);

        AssociadoResponseParameters associadoResponseParameters = associadoService.findAll(null, any(Pageable.class));

        assertEquals(expectedAssociadoResponseParameters, associadoResponseParameters);
    }

    private AssociadoResponseParameters getAssociadoResponseParameters() {
        return AssociadoResponseParameters.builder()
                .numberOfElements(1)
                .totalElements(1L)
                .totalPages(1)
                .associado(List.of(new AssociadoResponseDTO()))
                .build();
    }
}
