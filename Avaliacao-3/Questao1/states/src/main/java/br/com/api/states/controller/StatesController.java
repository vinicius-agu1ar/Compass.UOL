package br.com.api.states.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.states.controller.DTO.StatesDto;
import br.com.api.states.controller.form.StatesForm;
import br.com.api.states.model.States;
import br.com.api.states.repository.StatesRepository;

@RestController
@RequestMapping ("/api/states")
public class StatesController {

    @Autowired
    private StatesRepository statesRepository;
    
	@GetMapping
	public Page<StatesDto> listar (@RequestParam (required = false) String nomeRegiao,
	@PageableDefault (page = 0, size = 20, sort = "id")Pageable pageable) {

		if (nomeRegiao == null) {
			Page<States> topicos = statesRepository.findAll(pageable);
			return StatesDto.converter(topicos);
		} else {
			Page<States> topicos = statesRepository.findByRegiao(nomeRegiao, pageable);
			return StatesDto.converter(topicos);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<StatesDto> cadastrar (@RequestBody @Valid StatesForm statesForm, UriComponentsBuilder uriBuilder){
		
		States states = statesForm.converter(statesRepository);
		statesRepository.save(states);

		URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(states.getId()).toUri();
		return ResponseEntity.created(uri).body(new StatesDto(states));
	}

	@GetMapping ("/{id}")
	public ResponseEntity<StatesDto> detalhar (@PathVariable Long id){
		
		Optional<States> optionalStates = statesRepository.findById(id);
		if (optionalStates.isPresent()){
			return ResponseEntity.ok(new StatesDto(optionalStates.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping ("/{id}")
	@Transactional
	public ResponseEntity<StatesDto> atualizar (@PathVariable Long id, @RequestBody @Valid StatesForm statesForm){
		
		Optional<States> optionalStates = statesRepository.findById(id);
		if (optionalStates.isPresent()){
			States states = statesForm.atualizar(id, statesRepository);
			return ResponseEntity.ok(new StatesDto(states));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping ("/{id}")
	@Transactional
	public ResponseEntity<?> remover (@PathVariable Long id){
		
		Optional<States> optionalStates = statesRepository.findById(id);
		if (optionalStates.isPresent()){
			statesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} 
		return ResponseEntity.notFound().build();
	} 
}
