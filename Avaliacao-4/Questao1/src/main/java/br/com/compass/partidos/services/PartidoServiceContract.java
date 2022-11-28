package br.com.compass.partidos.services;

import org.springframework.data.domain.Pageable;

import br.com.compass.partidos.dto.request.PartidoRequestDTO;
import br.com.compass.partidos.dto.response.PartidoResponseDTO;
import br.com.compass.partidos.dto.response.PartidoResponseParameters;
import br.com.compass.partidos.enums.Ideologia;

public interface PartidoServiceContract {
    
    PartidoResponseDTO create(PartidoRequestDTO request);

    PartidoResponseParameters findAll(Ideologia ideologia, Pageable pageable);

    PartidoResponseDTO findById(Long id);

    PartidoResponseDTO findByIdAssociado(Long id);

    PartidoResponseDTO update(Long id, PartidoRequestDTO request);

    void delete(Long id);
}
