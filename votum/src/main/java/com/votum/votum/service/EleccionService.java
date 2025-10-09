package com.votum.votum.service;

import com.votum.votum.model.Eleccion;
import com.votum.votum.model.EstadoEleccion;
import com.votum.votum.model.User;
import com.votum.votum.repository.EleccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EleccionService {
    private final EleccionRepository eleccionRepository;

    public Eleccion createEleccion(Eleccion e, User creator){
        e.setCreador(creator);
        e.setEstado(EstadoEleccion.CREADA);
        return eleccionRepository.save(e);
    }

    public List<Eleccion> listarPorCreador(Long id){
        return eleccionRepository.findByCreador_Id(id);
    }


}
