package com.dosideas.repository;

import com.dosideas.domain.Pais;
import com.dosideas.domain.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    //@Query(value = "SELECT * FROM Provincia WHERE LOWER(nombre) = LOWER(?1)", nativeQuery = true)
    @Query(value = "SELECT p FROM Provincia p WHERE LOWER(p.nombre) = LOWER(:nombre)") // JPQL Query
    Provincia findByNombreIgnoreCase(String nombre);

    //@Query(value = "SELECT * FROM Provincia WHERE LOWER(nombre) LIKE CONCAT('%',LOWER(?1),'%')", nativeQuery = true)
    List<Provincia> findByNombreContainingIgnoreCase(String contenido);

    //@Query(value = "SELECT p.* FROM provincia as p INNER JOIN pais ON p.id_pais = pais.id AND LOWER(pais.nombre) = LOWER(?1)", nativeQuery = true)
    List<Provincia> findByPaisNombreIgnoreCase(String nombre);
}
