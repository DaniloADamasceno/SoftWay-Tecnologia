package br.com.danilo.softway.repository;

import br.com.danilo.softway.entity.Nutritionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NutritionistRepository extends JpaRepository<Nutritionist, UUID> {
}
