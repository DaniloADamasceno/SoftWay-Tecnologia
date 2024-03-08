package br.com.danilo.softway.entity.enums;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "tb_tipo_de_treino")
@Getter
@Entity
public enum TypeOfTraining {

    RESISTANCE(1, "TREINO RESISTÊNCIA"),            // --> Treino de resistência
    INTERVAL(2, "TREINO INTERVALADO"),              // --> Treino intervalado
    STRENGTH(3, "TREINO DE FORÇA"),                 // --> Treino de força
    SPEED(4, "TREINO DE VELOCIDADE"),               // --> Treino de velocidade
    TIMERUN(5, "TREINO DE TEMPO"),                  // --> Treino de corrida de tempo
    DISTANCE(6, "TREINO DE DISTÂNCIA"),             // --> Treino de corrida de distância
    FARTLEK(7, "TREINO FARTLEK"),                   // --> Treino de corrida fartlek
    HILL(8, "TREINO DE SUBIDA"),                    // --> Treino de corrida de subida
    RECOVERY(9, "TREINO DE RECUPERAÇÃO"),           // --> Treino de recuperação
    WARMUP(10, "TREINO DE AQUECIMENTO"),            // --> Treino de aquecimento
    COOLDOWN(11, "TREINO DE DESAQUECIMENTO");       // --> Treino de desaquecimento

    private final Integer codTypeOfTraining;                        // --> Código do tipo de treino
    private final String descriptionTypeOfTraining;                 // --> Descrição do tipo de treino

    @GeneratedValue(strategy = GenerationType.UUID)                 //  --> Auto incremento no banco de dados
    @Id
    private UUID idTypeOfTraining;                                  // --> ID do tipo de treino

    TypeOfTraining(Integer codTypeOfTraining, String descriptionTypeOfTraining) {
        this.codTypeOfTraining = codTypeOfTraining;
        this.descriptionTypeOfTraining = descriptionTypeOfTraining;
    }
}
