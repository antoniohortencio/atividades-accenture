package com.accenture.pessoa.controller;

import com.accenture.pessoa.config.security.TokenService;
import com.accenture.pessoa.entity.User;
import com.accenture.pessoa.entity.dtos.AuthenticationDTO;
import com.accenture.pessoa.entity.dtos.LoginResponseDTO;
import com.accenture.pessoa.entity.dtos.RegisterDTO;
import com.accenture.pessoa.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    // POST /auth/login — Autenticar e obter token JWT
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    // POST /auth/register — Registrar novo usuário
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO dto) {
        if (userRepository.findByLogin(dto.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = passwordEncoder.encode(dto.password());
        User newUser = new User(dto.login(), encryptedPassword, dto.role());
        userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
