package br.com.compass.partidos.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compass.partidos.entities.PartidoEntity;
import br.com.compass.partidos.enums.Ideologia;

public interface PartidoRepository extends JpaRepository<PartidoEntity, Long> {
    
    Page<PartidoEntity> findAllByIdeologia(Ideologia ideologia, Pageable page);
}
