package com.votum.votum.service;

import com.votum.votum.model.Eleccion;
import com.votum.votum.model.EleccionVotante;
import com.votum.votum.model.EstadoEleccion;
import com.votum.votum.model.User;
import com.votum.votum.repository.EleccionRepository;
import com.votum.votum.repository.EleccionVotanteRepository;
import com.votum.votum.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EleccionService {
    private final EleccionRepository eleccionRepository;
    private final UserRepository userRepository;
    private final EleccionVotanteRepository eleccionVotanteRepository;

    public Eleccion createEleccion(Eleccion e, User creator) {
        e.setCreador(creator);
        e.setEstado(EstadoEleccion.CREADA);
        return eleccionRepository.save(e);
    }

    public List<Eleccion> listarPorCreador(Long id) {
        return eleccionRepository.findByCreador_Id(id);
    }

    public List<EleccionVotante> agregarVotantes(Long eleccionId, List<String> correos, User creador) {
        Eleccion e = eleccionRepository.findById(eleccionId).orElseThrow(() -> new RuntimeException("Eleccion no encontrada"));

        if (!e.getCreador().getId().equals(creador.getId())) {
            throw new RuntimeException("No tienes permiso para modificar esta elección.");
        }

        if (e.getEstado() != (EstadoEleccion.CREADA) || e.getFechaInicio().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("No se pueden agregar votantes después del inicio de la elección.");
        }

        List<User> usuarios = userRepository.findByEmailIn(correos);

        List<EleccionVotante> nuevos = usuarios.stream()
                .map(u -> EleccionVotante.builder()
                        .eleccion(e)
                        .votante(u)
                        .haVotado(false)
                        .build())
                .toList();
        return eleccionVotanteRepository.saveAll(nuevos);
    }
}
