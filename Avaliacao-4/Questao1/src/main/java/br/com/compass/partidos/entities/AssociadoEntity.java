package br.com.compass.partidos.entities;

import java.time.LocalDate;

import javax.persistence.*;

import br.com.compass.partidos.enums.CargoPolitico;
import br.com.compass.partidos.enums.Sexo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ASSOCIADO")
public class AssociadoEntity {

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "CARGO")
    private CargoPolitico cargoPolitico;

    @Column(name = "NASCIMENTO")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO")
    private Sexo sexo;
    
    @ManyToOne (fetch = FetchType.LAZY)
    private PartidoEntity partidoEntity;
}
