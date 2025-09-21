package com.localsense.localSense.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.localsense.localSense.model.enums.DiaSemanaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "horario_funcionamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
