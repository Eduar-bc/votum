package com.votum.votum.repository;

import com.votum.votum.model.Eleccion;
import com.votum.votum.model.EstadoEleccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EleccionRepository extends JpaRepository<Eleccion, Long> {
    List<Eleccion> findByCreadorId(Long id);
}
