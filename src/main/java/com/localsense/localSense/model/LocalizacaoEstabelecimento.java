package com.localsense.localSense.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "localizacao")
public class LocalizacaoEstabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Double latitude;

    private Double longitude;

    private Double raioProximidade;

    @OneToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private EnderecoEstabelecimento enderecoEstabelecimento;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getRaioProximidade() {
        return raioProximidade;
    }

    public void setRaioProximidade(Double raioProximidade) {
        this.raioProximidade = raioProximidade;
    }

    public EnderecoEstabelecimento getEnderecoEstabelecimento() {
        return enderecoEstabelecimento;
    }

    public void setEnderecoEstabelecimento(EnderecoEstabelecimento enderecoEstabelecimento) {
        this.enderecoEstabelecimento = enderecoEstabelecimento;
    }
}
