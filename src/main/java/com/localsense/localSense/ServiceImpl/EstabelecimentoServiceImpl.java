package com.localsense.localSense.ServiceImpl;

import com.localsense.localSense.utilitarios.AtualizadorEstabelecimento;
import com.localsense.localSense.configSecurity.JwtUtil;
import com.localsense.localSense.loginEstabelecimento.AuthResponse;
import com.localsense.localSense.model.Estabelecimento;
import com.localsense.localSense.repository.EstabelecimentoRepository;
import com.localsense.localSense.service.EstabelecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

    private final EstabelecimentoRepository estabelecimentoRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

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

        estabelecimento.setSenha(passwordEncoder.encode(estabelecimento.getSenha()));
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
        Estabelecimento existente = buscarPorId(id);

        AtualizadorEstabelecimento.atualizarInformacoesPrincipais(existente, estabelecimento);
        AtualizadorEstabelecimento.atualizarEndereco(existente, estabelecimento.getEnderecoEstabelecimento());
        AtualizadorEstabelecimento.atualizarHorarioFuncionamento(existente, estabelecimento.getHorarioFuncionamento());

        return estabelecimentoRepository.save(existente);
    }

    @Override
    public void deletarEstabelecimento(UUID id) {
        Estabelecimento existente = estabelecimentoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado para o ID: " + id));
        estabelecimentoRepository.delete(existente);
    }

    @Override
    public Optional<Estabelecimento> autenticar(String email, String senha) {
        return estabelecimentoRepository.findByEmail(email).filter(estabelecimento -> passwordEncoder.matches(senha, estabelecimento.getSenha()));
    }

    @Override
    public AuthResponse login(String email, String senha) {
        return autenticar(email, senha).map(estabelecimento -> new AuthResponse(jwtUtil.generateToken(estabelecimento.getEmail()), estabelecimento.getId(), estabelecimento.getNomeFantasia())).orElseThrow(() -> new IllegalArgumentException("Email ou senha inválidos"));
    }


}
