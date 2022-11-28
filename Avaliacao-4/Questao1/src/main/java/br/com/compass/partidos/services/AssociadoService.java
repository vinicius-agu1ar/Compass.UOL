package br.com.compass.partidos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.compass.partidos.dto.request.AssociadoRequestDTO;
import br.com.compass.partidos.dto.response.AssociadoResponseDTO;
import br.com.compass.partidos.dto.response.AssociadoResponseParameters;
import br.com.compass.partidos.entities.AssociadoEntity;
import br.com.compass.partidos.enums.CargoPolitico;
import br.com.compass.partidos.exceptions.AssociadoNotFoundException;
import br.com.compass.partidos.repositories.AssociadoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssociadoService implements AssociadoServiceContract{

    private final ModelMapper modelMapper;
    private final AssociadoRepository associadoRepository;

    @Override
    public AssociadoResponseDTO create(AssociadoRequestDTO request) {
        AssociadoEntity associadoToCreate = modelMapper.map(request, AssociadoEntity.class);
        AssociadoEntity createdAssociado = associadoRepository.save(associadoToCreate);

        return modelMapper.map(createdAssociado, AssociadoResponseDTO.class);
    }

    @Override
    public AssociadoResponseParameters associate(Long idPartido, Long idAssociado) {
        return null;
    }

    @Override
    public AssociadoResponseParameters findAll(CargoPolitico cargoPolitico, Pageable pageable) {
        Page<AssociadoEntity> page = cargoPolitico == null ?
            associadoRepository.findAll(pageable) :
            associadoRepository.findAllByCargoPolitico(cargoPolitico, pageable);

        return createAssociadoResponseParameters(page);
    }

    @Override
    public AssociadoResponseDTO findById(Long id) {
        AssociadoEntity associado = getAssociadoEntity(id);

        return modelMapper.map(associado, AssociadoResponseDTO.class);
    }

    @Override
    public AssociadoResponseDTO update(Long id, AssociadoRequestDTO request) {
        getAssociadoEntity(id);

        AssociadoEntity associadoToUpdate = modelMapper.map(request, AssociadoEntity.class);
        associadoToUpdate.setId(id);
        AssociadoEntity updatedAssociado = associadoRepository.save(associadoToUpdate);

        return modelMapper.map(updatedAssociado, AssociadoResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        getAssociadoEntity(id);
        associadoRepository.deleteById(id);
    }

    @Override
    public AssociadoResponseDTO disassociate(Long idPartido, Long idAssociado, AssociadoRequestDTO request) {
        return null;
    }

    private AssociadoResponseParameters createAssociadoResponseParameters(Page<AssociadoEntity> page) {
        List<AssociadoResponseDTO> associado = page.stream()
                .map(this::createAssociadoResponseDTO)
                .collect(Collectors.toList());

        return AssociadoResponseParameters.builder()
                .numberOfElements(page.getNumberOfElements())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .associado(associado)
                .build();
    }

    private AssociadoResponseDTO createAssociadoResponseDTO(AssociadoEntity associado) {
        return modelMapper.map(associado, AssociadoResponseDTO.class);
    }
    
    private AssociadoEntity getAssociadoEntity(Long id) {
        return associadoRepository.findById(id)
                .orElseThrow(AssociadoNotFoundException::new);
    }
    
}
