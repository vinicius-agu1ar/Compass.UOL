package br.com.compass.partidos.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compass.partidos.entities.AssociadoEntity;
import br.com.compass.partidos.enums.CargoPolitico;

public interface AssociadoRepository extends JpaRepository<AssociadoEntity, Long> {
    
    Page<AssociadoEntity> findAllByCargoPolitico(CargoPolitico cargoPolitico, Pageable page);
}
