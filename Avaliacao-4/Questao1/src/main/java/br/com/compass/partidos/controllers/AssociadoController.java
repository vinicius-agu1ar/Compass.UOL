package br.com.compass.partidos.controllers;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

import br.com.compass.partidos.dto.request.AssociadoRequestDTO;
import br.com.compass.partidos.dto.response.AssociadoResponseDTO;
import br.com.compass.partidos.dto.response.AssociadoResponseParameters;
import br.com.compass.partidos.enums.CargoPolitico;
import br.com.compass.partidos.services.AssociadoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AssociadoController {

    private final AssociadoService associadoService;
    
    @PostMapping(value = "/associados")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<AssociadoResponseDTO> create(@RequestBody @Valid AssociadoRequestDTO request) {
        AssociadoResponseDTO response = associadoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/associados")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<AssociadoResponseParameters> findAll(@RequestParam(required = false) CargoPolitico cargoPolitico, Pageable pageable) {
        AssociadoResponseParameters response = associadoService.findAll(cargoPolitico, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/associados/{id}")
    public ResponseEntity<AssociadoResponseDTO> findById(@PathVariable("id")Long id) {
        AssociadoResponseDTO response = associadoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(value = "/associados/{id}")
    public ResponseEntity<AssociadoResponseDTO> update(@PathVariable("id") Long id, @RequestBody @Valid AssociadoRequestDTO request) {
        AssociadoResponseDTO response = associadoService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/associados/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        associadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}