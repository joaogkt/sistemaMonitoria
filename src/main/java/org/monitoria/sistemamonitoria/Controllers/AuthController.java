package org.monitoria.sistemamonitoria.Controllers;

import org.monitoria.sistemamonitoria.Auth.JwtUtil;
import org.monitoria.sistemamonitoria.DTO.LoginRequestDTO;
import org.monitoria.sistemamonitoria.DTO.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        authManager.authenticate(authInputToken);

        String token = jwtUtil.generateToken(request.getEmail());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
