package com.localsense.localSense.utilitarios;

import com.localsense.localSense.model.EnderecoEstabelecimento;
import com.localsense.localSense.model.Estabelecimento;
import com.localsense.localSense.model.HorarioFuncionamento;

public class AtualizadorEstabelecimento {

    public AtualizadorEstabelecimento() {
    }

    public static void atualizarInformacoesPrincipais(Estabelecimento existente, Estabelecimento novo) {
        existente.setEmail(novo.getEmail());
        existente.setSenha(novo.getSenha()); // criptografar se necessário
        existente.setNomeFantasia(novo.getNomeFantasia());
        existente.setRazaoSocial(novo.getRazaoSocial());
        existente.setCnpj(novo.getCnpj());
        existente.setDescricao(novo.getDescricao());
        existente.setTelefone(novo.getTelefone());
        existente.setStatus(novo.getStatus());
        existente.setMidias(novo.getMidias());
    }

    public static void atualizarEndereco(Estabelecimento existente, EnderecoEstabelecimento novoEndereco) {
        if (novoEndereco != null) {
            novoEndereco.setEstabelecimento(existente);
            existente.setEnderecoEstabelecimento(novoEndereco);
        }
    }

    public static void atualizarHorarioFuncionamento(Estabelecimento existente, HorarioFuncionamento novoHorario) {
        if (novoHorario != null) {
            existente.setHorarioFuncionamento(novoHorario);
        }
    }
}
