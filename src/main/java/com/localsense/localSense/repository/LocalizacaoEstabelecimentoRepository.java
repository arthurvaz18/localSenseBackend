package com.localsense.localSense.repository;

import com.localsense.localSense.model.LocalizacaoEstabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocalizacaoEstabelecimentoRepository extends JpaRepository<LocalizacaoEstabelecimento, UUID> {
}
