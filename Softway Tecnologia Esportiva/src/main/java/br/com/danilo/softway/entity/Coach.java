package br.com.danilo.softway.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Coach implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)       // Gerar um valor de ID automaticamente
    private UUID idCoach;    // --> ID do treinador

    private User user;          // --> Todos os atletas são usuários
}
