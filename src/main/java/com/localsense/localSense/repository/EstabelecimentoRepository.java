package com.localsense.localSense.repository;

import com.localsense.localSense.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, UUID> {
    boolean existsByCnpj(String cnpj);
    boolean existsByEmail(String email);
}
