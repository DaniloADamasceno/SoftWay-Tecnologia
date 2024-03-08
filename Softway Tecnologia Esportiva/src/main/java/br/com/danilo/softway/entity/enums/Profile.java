package br.com.danilo.softway.entity.enums;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "tb_perfis")
@Getter
@Entity
public enum Profile {

    USER(1, "PROFILE_USER"),
    ATHLETE(2, "PROFILE_ATHLETE"),
    COACH(3, "PROFILE_COACH"),
    NUTRITIONIST(4, "PROFILE_NUTRITIONIST");

    private final Integer codProfile;
    private final String descriptionProfile;

    @GeneratedValue(strategy = GenerationType.UUID)                 //  --> Auto incremento no banco de dados
    @Id
    private UUID idProfile;

    //! ------------------------------------------   CONSTRUCTORS   ----------------------------------------------------

    Profile(Integer codProfile, String descriptionProfile) {
        this.codProfile = codProfile;
        this.descriptionProfile = descriptionProfile;
    }

    //!  -------------------------------------------------  Methods  ---------------------------------------------------

    public static Profile toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Profile numberProfile : Profile.values()) {
            if (cod.equals(numberProfile.getCodProfile())) {
                return numberProfile;
            }
        }
        throw new IllegalArgumentException("⚠️ ⚠️ ️invalid PROFILE ID: / ID invalido de PERFIL ⚠️ ⚠️" + cod);
    }
}
