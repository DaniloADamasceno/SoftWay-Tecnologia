package br.com.danilo.softway.entity;

import br.com.danilo.softway.entity.enums.Profile;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_usuarios")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)       // Gerar um valor de ID automaticamente
    private UUID userId;

    @NotBlank                                  // Não pode ser vazio
    @Column(name = "nome_usuario")
    private String username;

    @NotBlank                                  // Não pode ser vazio
    @Column(name = "email")
    private String email;

    @NotBlank                                  // Não pode ser vazio
    @Size(min = 4, max = 10)                   // Deve ter entre 4 e 10 caracteres
    @Column(name = "senha")
    private String password;

    @Size(min = 8, max = 11)                   // Deve ter entre 8 e 11 caracteres
    private Integer phone;                     // --> Telefone

    @CreationTimestamp                         // Data de criação
    private Instant creationTimestamp;

    @UpdateTimestamp                           // Data de atualização
    private Instant updateTimestamp;

    @ManyToMany
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id"))
    private Set<Profile> profiles = new HashSet<>();

    //! ------------------------------------------   CONSTRUCTORS   ----------------------------------------------------
    public User() {
        super();
        addProfile(Profile.USER);                 //-> Todos os novos usuarios são criados com o perfil de usuário
    }

    public User(UUID userId, String username, String email, String password, Integer phone, Instant creationTimestamp,
                Instant updateTimestamp) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
        addProfile(Profile.USER);                   //-> Todos os novos Usuários são cadastrados como Usuários
    }

    //! ------------------------------------------   GETTERS AND SETTERS   ---------------------------------------------
    public Set<Profile> getProfile() {
        return profiles;
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile);
    }

    // ! ---------------------------------------------  HashCode and Equals --------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }
}
