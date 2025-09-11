package com.localsense.localSense.ServiceImpl;

import com.localsense.localSense.model.Estabelecimento;
import com.localsense.localSense.repository.EstabelecimentoRepository;
import com.localsense.localSense.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

    @Autowired
    EstabelecimentoRepository estabelecimentoRepository;

    @Override
    public Estabelecimento criarEstabelecimento(Estabelecimento estabelecimento) {
        if (estabelecimentoRepository.existsByCnpj(estabelecimento.getCnpj())) {
            throw new IllegalArgumentException("CNPJ já cadastrado");
        }
        if (estabelecimentoRepository.existsByEmail(estabelecimento.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        // Vincula o endereço
        if (estabelecimento.getEnderecoEstabelecimento() != null) {
            estabelecimento.getEnderecoEstabelecimento().setEstabelecimento(estabelecimento);
        }

        return estabelecimentoRepository.save(estabelecimento);
    }

}
