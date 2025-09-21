package com.localsense.localSense.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "endereco_estabelecimento")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoEstabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    private String pais;

    @NotBlank
    private String estado;

    @NotBlank
    private String cep;

    @NotBlank
    private String cidade;

    @NotBlank
    private String rua;

    @NotBlank
    private String numero;

    private String complemento;

    @CreatedDate
    @Column(updatable = false)
    private LocalDate criadoEm;

    @LastModifiedDate
    private LocalDate atualizadoEm;

    @OneToOne(mappedBy = "enderecoEstabelecimento")
    @JsonIgnoreProperties("enderecoEstabelecimento")
    private Estabelecimento estabelecimento;

    @OneToOne(mappedBy = "enderecoEstabelecimento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("enderecoEstabelecimento")
    private LocalizacaoEstabelecimento localizacaoEstabelecimento;
}
