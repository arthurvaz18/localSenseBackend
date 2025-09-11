package com.localsense.localSense.resource;

import com.localsense.localSense.model.Estabelecimento;
import com.localsense.localSense.service.EstabelecimentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrarEstabelecimentos")
public class EstabelecimentoResource {

    private final EstabelecimentoService estabelecimentoService;

    public EstabelecimentoResource(EstabelecimentoService estabelecimentoService) {
        this.estabelecimentoService = estabelecimentoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Estabelecimento> criarEstabelecimento(@Valid @RequestBody Estabelecimento estabelecimento) {
        Estabelecimento criado = estabelecimentoService.criarEstabelecimento(estabelecimento);
        return ResponseEntity.ok(criado);
    }
}
