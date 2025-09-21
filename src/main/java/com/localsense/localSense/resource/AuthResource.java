package com.localsense.localSense.resource;

import com.localsense.localSense.loginEstabelecimento.AuthResponse;
import com.localsense.localSense.loginEstabelecimento.LoginRequest;
import com.localsense.localSense.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthResource {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse response = estabelecimentoService.login(loginRequest.getEmail(), loginRequest.getSenha());
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
    }
}
