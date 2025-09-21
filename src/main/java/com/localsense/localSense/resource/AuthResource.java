package com.localsense.localSense.resource;

import com.localsense.localSense.loginEstabelecimento.AuthResponse;
import com.localsense.localSense.loginEstabelecimento.LoginRequest;
import com.localsense.localSense.service.EstabelecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor

public class AuthResource {

    final EstabelecimentoService estabelecimentoService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse response = estabelecimentoService.login(loginRequest.getEmail(), loginRequest.getSenha());
        return ResponseEntity.ok(response);
    }
}
