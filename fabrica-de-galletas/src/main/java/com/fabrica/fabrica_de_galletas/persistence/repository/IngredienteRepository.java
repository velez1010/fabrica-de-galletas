package com.fabrica.fabrica_de_galletas.persistence.repository;
import com.fabrica.fabrica_de_galletas.core.domain.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{

}
