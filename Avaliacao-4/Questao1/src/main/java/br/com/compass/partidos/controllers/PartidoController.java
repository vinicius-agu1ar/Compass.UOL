package br.com.compass.partidos.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.compass.partidos.dto.request.PartidoRequestDTO;
import br.com.compass.partidos.dto.response.PartidoResponseDTO;
import br.com.compass.partidos.dto.response.PartidoResponseParameters;
import br.com.compass.partidos.enums.Ideologia;
import br.com.compass.partidos.services.PartidoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PartidoController {

    private final PartidoService partidoService;
    
    @PostMapping(value = "/partidos")
    public ResponseEntity<PartidoResponseDTO> create(@RequestBody @Valid PartidoRequestDTO request) {
        PartidoResponseDTO response = partidoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/partidos")
    public ResponseEntity<PartidoResponseParameters> findAll(@RequestParam(required = false) Ideologia ideologia, Pageable pageable) {
        PartidoResponseParameters response = partidoService.findAll(ideologia, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/partidos/{id}")
    public ResponseEntity<PartidoResponseDTO> findById(@PathVariable("id") Long id) {
        PartidoResponseDTO response = partidoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @GetMapping(value = "/partidos/{id}/associados")
    public ResponseEntity<PartidoResponseDTO> findByIdAssociado(@PathVariable("id")Long id) {
        PartidoResponseDTO response = partidoService.findByIdAssociado(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(value = "/partidos/{id}")
    public ResponseEntity<PartidoResponseDTO> update(@PathVariable("id") Long id, @RequestBody @Valid PartidoRequestDTO request) {
        PartidoResponseDTO response = partidoService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/partidos/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        partidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
