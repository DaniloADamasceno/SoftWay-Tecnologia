package br.com.danilo.softway.entity;

import br.com.danilo.softway.entity.enums.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tb_atletas")
public class Athlete implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)                 // Gerar um valor de ID automaticamente
    private UUID idAthlete;                                         // --> ID do atleta

    @OneToOne
    @JoinTable(
            name = "usuario_atleta",
            joinColumns = @JoinColumn(name = "id_atleta"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private User user;                                              // --> Todos os atletas são usuários
    private Integer age;                                            // --> Idade do atleta
    private String weight;                                          // --> Peso do atleta
    private String height;                                          // --> Altura do atleta

    @CollectionTable(name = "perfil_atleta")                        //-> Nome da tabela que vai ser criada
    @OneToMany
    @JoinColumn(name = "id_atleta")                                 //-> Nome da coluna que vai ser criada
    private Set<Profile> profiles = new HashSet<>();

    @OneToMany(mappedBy = "athlete")
    private ArrayList<Training> trainingsAthlete;                   // --> Lista de Treinos do atleta

    //! ------------------------------------------   GETTERS AND SETTERS   ---------------------------------------------
    public Set<Profile> getProfile() {
        return profiles;
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile);
    }
}
