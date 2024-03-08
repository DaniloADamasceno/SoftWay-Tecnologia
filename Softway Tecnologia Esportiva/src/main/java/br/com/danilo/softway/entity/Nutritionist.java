package br.com.danilo.softway.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.awt.image.BufferedImage;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Nutritionist implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy= GenerationType.UUID)       // Gerar um valor de ID automaticamente
    private UUID idNutritionist;                         // --> ID do nutricionista

    private User user;                  // --> Todos os atletas são usuários
    private String crn;                 // --> Conselho Regional de Nutrição

    //? AREA DE DESCRIÇÃO DO NUTRICIONISTA
//    private BufferedImage photo;            // --> Foto do nutricionista
    private String description;             // --> Descrição do nutricionista
    private String emailNutritionist;       // --> Email do nutricionista Pode ser diferente do email do usuário


    //? AREA DE CONTATO DO NUTRICIONISTA
    private String websiteNutritionist;     // --> Site do nutricionista
    private String instagramNutritionist;   // --> Instagram do nutricionista
    private String facebookNutritionist;    // --> Facebook do nutricionista
    private String linkedinNutritionist;    // --> Linkedin do nutricionista
    private String telegramNutritionist;    // --> Telegram do nutricionista

    @Size(min = 8, max = 11)                   // Deve ter entre 8 e 11 caracteres
    private Integer phoneNutritionist;       // --> Telefone do nutricionista


}

