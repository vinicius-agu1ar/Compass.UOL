package br.com.compass.partidos.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import br.com.compass.partidos.enums.Ideologia;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PARTIDO")
public class PartidoEntity {
    
    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SIGLA")
    private String sigla;

    @Enumerated(EnumType.STRING)
    @Column(name = "IDEOLOGIA")
    private Ideologia ideologia;

    @Column(name = "FUNDACAO")
    private LocalDateTime dataFundacao;
    
    @OneToMany (mappedBy = "partidoEntity",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<AssociadoEntity> associadoEntity;

}
