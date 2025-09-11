package com.localsense.localSense.resource;

import com.localsense.localSense.model.Estabelecimento;
import com.localsense.localSense.service.EstabelecimentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/listar")
    public ResponseEntity<List<Estabelecimento>> listarEstabelecimentos() {
        List<Estabelecimento> estabelecimentos = estabelecimentoService.listarEstabelecimentos();
        return ResponseEntity.ok(estabelecimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estabelecimento> buscarPorId(@PathVariable UUID id) {
        Estabelecimento estabelecimento = estabelecimentoService.buscarPorId(id);
        return ResponseEntity.ok(estabelecimento);
    }

    @PutMapping("/editar")
    public ResponseEntity<Estabelecimento> atualizarEstabelecimento(@PathVariable UUID id, @Valid @RequestBody Estabelecimento estabelecimento) {
        Estabelecimento atualizado = estabelecimentoService.atualizarEstabelecimento(id, estabelecimento);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstabelecimento(@PathVariable UUID id) {
        estabelecimentoService.deletarEstabelecimento(id);
        return ResponseEntity.noContent().build();
    }

}
