package com.localsense.localSense.resource;

import com.localsense.localSense.configSecurity.JwtUtil;
import com.localsense.localSense.loginEstabelecimento.AuthResponse;
import com.localsense.localSense.loginEstabelecimento.LoginRequest;
import com.localsense.localSense.model.Estabelecimento;
import com.localsense.localSense.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthResource {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Estabelecimento> estOpt = estabelecimentoService.autenticar(loginRequest.getEmail(), loginRequest.getSenha());

        if (estOpt.isPresent()) {
            Estabelecimento est = estOpt.get();
            String token = jwtUtil.generateToken(est.getEmail());

            AuthResponse response = new AuthResponse(token, est.getId(), est.getNomeFantasia());
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
    }
}
