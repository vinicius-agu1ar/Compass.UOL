package br.com.compass.partidos.services;

import org.springframework.data.domain.Pageable;

import br.com.compass.partidos.dto.request.AssociadoRequestDTO;
import br.com.compass.partidos.dto.response.AssociadoResponseDTO;
import br.com.compass.partidos.dto.response.AssociadoResponseParameters;
import br.com.compass.partidos.enums.CargoPolitico;

public interface AssociadoServiceContract {

    AssociadoResponseDTO create(AssociadoRequestDTO request);

    AssociadoResponseParameters associate(Long idPartido, Long idAssociado);

    AssociadoResponseParameters findAll(CargoPolitico cargoPolitico, Pageable pageable);

    AssociadoResponseDTO findById(Long id);

    AssociadoResponseDTO update(Long id, AssociadoRequestDTO request);

    void delete(Long id);

    AssociadoResponseDTO disassociate(Long idPartido, Long idAssociado, AssociadoRequestDTO request);
}