package com.fabrica.fabrica_de_galletas.persistence.repository;
import com.fabrica.fabrica_de_galletas.core.domain.Galleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface GalletaRepository extends JpaRepository<Galleta, Long>{

    List<Galleta> findBySabor(String sabor);


}
