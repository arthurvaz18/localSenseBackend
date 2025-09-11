package com.localsense.localSense.ServiceImpl;

import com.localsense.localSense.model.Estabelecimento;
import com.localsense.localSense.repository.EstabelecimentoRepository;
import com.localsense.localSense.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        if (estabelecimento.getEnderecoEstabelecimento() != null) {
            estabelecimento.getEnderecoEstabelecimento().setEstabelecimento(estabelecimento);
        }

        return estabelecimentoRepository.save(estabelecimento);
    }

    @Override
    public List<Estabelecimento> listarEstabelecimentos() {
        return estabelecimentoRepository.findAll();
    }

    @Override
    public Estabelecimento buscarPorId(UUID id) {
        return estabelecimentoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado para o ID: " + id));
    }

    @Override
    public Estabelecimento atualizarEstabelecimento(UUID id, Estabelecimento estabelecimento) {
        Estabelecimento existente = estabelecimentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado para o ID: " + id));

        // Atualiza campos
        existente.setEmail(estabelecimento.getEmail());
        existente.setSenha(estabelecimento.getSenha());
        existente.setNomeFantasia(estabelecimento.getNomeFantasia());
        existente.setRazaoSocial(estabelecimento.getRazaoSocial());
        existente.setCnpj(estabelecimento.getCnpj());
        existente.setDescricao(estabelecimento.getDescricao());
        existente.setTelefone(estabelecimento.getTelefone());
        existente.setStatus(estabelecimento.getStatus());
        existente.setMidias(estabelecimento.getMidias());

        // Atualiza endereço
        if (estabelecimento.getEnderecoEstabelecimento() != null) {
            estabelecimento.getEnderecoEstabelecimento().setEstabelecimento(existente);
            existente.setEnderecoEstabelecimento(estabelecimento.getEnderecoEstabelecimento());
        }

        // Atualiza horário
        if (estabelecimento.getHorarioFuncionamento() != null) {
            existente.setHorarioFuncionamento(estabelecimento.getHorarioFuncionamento());
        }

        return estabelecimentoRepository.save(existente);
    }

    @Override
    public void deletarEstabelecimento(UUID id) {
        Estabelecimento existente = estabelecimentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado para o ID: " + id));
        estabelecimentoRepository.delete(existente);
    }


}
