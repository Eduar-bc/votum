package com.votum.votum.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        String email = null;
        String jwt = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")){
            jwt = authHeader.substring(7);
            try {
                email = jwtUtil.extractUsername(jwt);
            } catch (Exception e) {
                // token no válido, se ignorará y la solicitud llegará al punto de entrada de seguridad
                //throw new RuntimeException(e);
            }
        }

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails ud = userDetailsService.loadUserByUsername(email);
            if (jwtUtil.validateToken(jwt, ud.getUsername())){
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        ud, null, ud.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(auth);

            }
        }
        filterChain.doFilter(request, response);

    }
}
