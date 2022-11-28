package br.com.compass.partidos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.compass.partidos.dto.request.PartidoRequestDTO;
import br.com.compass.partidos.dto.response.PartidoResponseDTO;
import br.com.compass.partidos.dto.response.PartidoResponseParameters;
import br.com.compass.partidos.entities.PartidoEntity;
import br.com.compass.partidos.enums.Ideologia;
import br.com.compass.partidos.exceptions.PartidoNotFoundException;
import br.com.compass.partidos.repositories.PartidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoService implements PartidoServiceContract{
    
    private final ModelMapper modelMapper;
    private final PartidoRepository partidoRepository;

    @Override
    public PartidoResponseDTO create(PartidoRequestDTO request) {
        PartidoEntity partidoToCreate = modelMapper.map(request, PartidoEntity.class);
        PartidoEntity createdPartido = partidoRepository.save(partidoToCreate);

        return modelMapper.map(createdPartido, PartidoResponseDTO.class);
    }

    @Override
    public PartidoResponseParameters findAll(Ideologia ideologia, Pageable pageable) {
        Page<PartidoEntity> page = ideologia == null ?
                partidoRepository.findAll(pageable) :
                partidoRepository.findAllByIdeologia(ideologia, pageable);

        return createPartidoResponseParameters(page);
    }

    @Override
    public PartidoResponseDTO findById(Long id) {
        PartidoEntity partido = getPartidoEntity(id);

        return modelMapper.map(partido, PartidoResponseDTO.class);
    }

    @Override
    public PartidoResponseDTO findByIdAssociado(Long id) {
        return null;
    }

    @Override
    public PartidoResponseDTO update(Long id, PartidoRequestDTO request) {
        getPartidoEntity(id);

        PartidoEntity partidoToUpdate = modelMapper.map(request, PartidoEntity.class);
        partidoToUpdate.setId(id);
        PartidoEntity updatedPartido = partidoRepository.save(partidoToUpdate);

        return modelMapper.map(updatedPartido, PartidoResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        getPartidoEntity(id);
        partidoRepository.deleteById(id);
    }

    private PartidoResponseParameters createPartidoResponseParameters(Page<PartidoEntity> page) {
        List<PartidoResponseDTO> partido = page.stream()
                .map(this::createPartidoResponseDTO)
                .collect(Collectors.toList());

        return PartidoResponseParameters.builder()
                .numberOfElements(page.getNumberOfElements())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .partido(partido)
                .build();
    }

    private PartidoResponseDTO createPartidoResponseDTO(PartidoEntity partido) {
        return modelMapper.map(partido, PartidoResponseDTO.class);
    }
    
    private PartidoEntity getPartidoEntity(Long id) {
        return partidoRepository.findById(id)
                .orElseThrow(PartidoNotFoundException::new);
    }
}
