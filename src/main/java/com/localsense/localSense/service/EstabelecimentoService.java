package com.localsense.localSense.service;

import com.localsense.localSense.model.Estabelecimento;

import java.util.List;

public interface EstabelecimentoService {
    Estabelecimento criarEstabelecimento(Estabelecimento estabelecimento);
    List<Estabelecimento> listarEstabelecimentos();

}
