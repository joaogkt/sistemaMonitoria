package org.monitoria.sistemamonitoria.Controllers;

import org.monitoria.sistemamonitoria.Auth.JwtUtil;
import org.monitoria.sistemamonitoria.DTO.LoginRequestDTO;
import org.monitoria.sistemamonitoria.DTO.LoginResponseDTO;
import org.monitoria.sistemamonitoria.Models.User;
import org.monitoria.sistemamonitoria.Repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        authManager.authenticate(authInputToken);

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole(), user.getName(), user.getId());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}