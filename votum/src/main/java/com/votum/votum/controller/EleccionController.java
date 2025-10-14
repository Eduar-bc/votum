package com.votum.votum.controller;

import com.votum.votum.model.Eleccion;
import com.votum.votum.model.EleccionVotante;
import com.votum.votum.model.User;
import com.votum.votum.repository.UserRepository;
import com.votum.votum.service.EleccionService;
import com.votum.votum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/elections")
@RequiredArgsConstructor
public class EleccionController {
    private final EleccionService electionService;
    private final UserRepository userRepository;


    @PostMapping
    public ResponseEntity<Eleccion> createEleccion(@RequestBody Eleccion e, @AuthenticationPrincipal UserDetails userDetails) {
        User creator = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Eleccion nueva = electionService.createEleccion(e, creator);
        return ResponseEntity.ok(nueva);
    }

    @GetMapping
    public ResponseEntity<List<Eleccion>> listar(@AuthenticationPrincipal UserDetails userDetails) {
        User creator = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return ResponseEntity.ok(electionService.listarPorCreador(creator.getId()));
    }

    @PostMapping("/{id}/votantes")
    public ResponseEntity<?> agregarVotantes(
            @PathVariable Long id,
            @RequestBody Map<String, List<String>> request,
            @AuthenticationPrincipal UserDetails userDetails) {

        User creator = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<String> correos = request.get("correos");

        List<EleccionVotante> agregados = electionService.agregarVotantes(id, correos, creator);

        return ResponseEntity.ok(agregados);
    }
}
