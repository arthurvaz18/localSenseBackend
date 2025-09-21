package com.localsense.localSense.service;

import com.localsense.localSense.loginEstabelecimento.AuthResponse;
import com.localsense.localSense.model.Estabelecimento;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstabelecimentoService {
    Estabelecimento criarEstabelecimento(Estabelecimento estabelecimento);
    List<Estabelecimento> listarEstabelecimentos();
    Estabelecimento buscarPorId(UUID id);
    Estabelecimento atualizarEstabelecimento(UUID id, Estabelecimento estabelecimento);
    void deletarEstabelecimento(UUID id);
    Optional<Estabelecimento> autenticar(String email, String senha);
    AuthResponse login(String email, String senha);


}
