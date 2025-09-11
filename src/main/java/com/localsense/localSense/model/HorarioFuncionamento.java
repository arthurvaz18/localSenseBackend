package com.localsense.localSense.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.localsense.localSense.model.enums.DiaSemanaEnum;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "horario_funcionamento")
public class HorarioFuncionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private DiaSemanaEnum diaSemanaInicio;

    @Enumerated(EnumType.STRING)
    private DiaSemanaEnum diaSemanaFim;

    private LocalTime horaAbertura;
    private LocalTime horaFechamento;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    @JsonIgnoreProperties("horarioFuncionamento")
    private Estabelecimento estabelecimento;

    private String observacao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DiaSemanaEnum getDiaSemanaInicio() {
        return diaSemanaInicio;
    }

    public void setDiaSemanaInicio(DiaSemanaEnum diaSemanaInicio) {
        this.diaSemanaInicio = diaSemanaInicio;
    }

    public DiaSemanaEnum getDiaSemanaFim() {
        return diaSemanaFim;
    }

    public void setDiaSemanaFim(DiaSemanaEnum diaSemanaFim) {
        this.diaSemanaFim = diaSemanaFim;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(LocalTime horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(LocalTime horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}

