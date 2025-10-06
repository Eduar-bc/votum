package com.votum.votum.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votum.votum.dto.LoginRequest;
import com.votum.votum.dto.LoginResponse;
import com.votum.votum.dto.RegisterRequest;
import com.votum.votum.model.Role;
import com.votum.votum.model.User;
import com.votum.votum.repository.UserRepository;
import com.votum.votum.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
private final AuthenticationManager authManager;
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (userRepo.existsByEmail(req.getEmail())) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        User u = User.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .roles(Set.of(Role.ROLE_VOTER))
                .enabled(true)
                .build();
        userRepo.save(u);
        return ResponseEntity.ok("User created");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        try {
            // Intenta autenticar con los datos del usuario
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
            );

            // Si llega aquí, la autenticación fue exitosa
            String token = jwtUtil.generateToken(req.getEmail());
            return ResponseEntity.ok(new LoginResponse(token));

        } catch (org.springframework.security.authentication.BadCredentialsException e) {
            // Contraseña incorrecta
            return ResponseEntity.status(401).body("❌ Credenciales incorrectas: revisa el usuario o la contraseña.");
        } catch (org.springframework.security.authentication.DisabledException e) {
            // Usuario deshabilitado
            return ResponseEntity.status(403).body("Usuario deshabilitado, contacta al administrador.");
        } catch (org.springframework.security.core.userdetails.UsernameNotFoundException e) {
            // Usuario no existe
            return ResponseEntity.status(404).body("Usuario no encontrado.");
        } catch (Exception e) {
            // Cualquier otro error inesperado
            return ResponseEntity.status(500).body("Error interno en el proceso de login: " + e.getMessage());
        }
    }





//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
//        Authentication auth = authManager.authenticate(
//                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
//        );
//        String token = jwtUtil.generateToken(req.getUsername());
//        return ResponseEntity.ok(new LoginResponse(token));
//    }
}
