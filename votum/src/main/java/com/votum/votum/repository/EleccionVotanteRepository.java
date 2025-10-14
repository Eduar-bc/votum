package com.votum.votum.repository;

import com.votum.votum.model.EleccionVotante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EleccionVotanteRepository extends JpaRepository<EleccionVotante, Long> {
    List<EleccionVotante> findByEleccion_Id(Long id);
}
