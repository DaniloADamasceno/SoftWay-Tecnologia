package br.com.danilo.softway.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "treinos")
public class Training implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idTraining; // --> ID do treino

    private String nameTraining; // --> Nome do treino
    private String descriptionTraining; // --> Descrição do treino

    @ManyToOne
    @JoinColumn(name = "id_atleta")
    private Athlete athlete;

}
