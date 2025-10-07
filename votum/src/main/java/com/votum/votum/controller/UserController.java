package com.votum.votum.controller;


import com.votum.votum.model.User;
import com.votum.votum.repository.UserRepository;
import com.votum.votum.security.JwtUtil;
import com.votum.votum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/become-creator")
    public ResponseEntity<?> becomeCreator(@AuthenticationPrincipal UserDetails userDetails){
        User u = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        userService.becomeCreator(u);

        Collection<? extends GrantedAuthority> authorities = u.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.name()))
                .toList();

        String newToken = jwtUtil.generateToken(u.getEmail(), authorities);

        return ResponseEntity.ok(Map.of(
                "message", "Ahora eres creador de elecciones",
                "token", newToken
        ));
    }
}
