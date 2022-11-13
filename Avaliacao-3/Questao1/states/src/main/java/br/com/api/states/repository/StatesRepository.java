package br.com.api.states.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.states.model.States;

public interface StatesRepository extends JpaRepository <States, Long>{

    Page<States> findByRegiao(String nomeRegiao, Pageable pageable);
    
}
