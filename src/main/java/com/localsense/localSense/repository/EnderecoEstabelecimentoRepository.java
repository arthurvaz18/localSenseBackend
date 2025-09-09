package com.localsense.localSense.repository;

import com.localsense.localSense.model.EnderecoEstabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoEstabelecimentoRepository extends JpaRepository<EnderecoEstabelecimento, UUID> {
}
