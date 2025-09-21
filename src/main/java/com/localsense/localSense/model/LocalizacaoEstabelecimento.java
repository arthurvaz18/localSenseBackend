package com.localsense.localSense.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "localizacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalizacaoEstabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Double latitude;
    private Double longitude;
    private Double raioProximidade;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", nullable = false)
    @JsonIgnoreProperties({"localizacaoEstabelecimento", "estabelecimento"})
    private EnderecoEstabelecimento enderecoEstabelecimento;
}
