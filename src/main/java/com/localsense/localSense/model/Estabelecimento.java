package com.localsense.localSense.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "estabelecimento")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Email
    @NotBlank
    @Column(nullable = false)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @Size(min = 6)
    @Column(nullable = false)
    private String senha;

    @NotBlank
    @Column(name = "nome_fantasia", length = 150)
    private String nomeFantasia;

    @NotBlank
    @Column(name = "razao_social", length = 150)
    private String razaoSocial;

    @CNPJ
    @NotBlank
    @Column(length = 14, unique = true, nullable = false)
    private String cnpj;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @NotBlank
    @Column(length = 15)
    private String telefone;

    private Boolean status;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "JSONB")
    private List<String> midias;

    @CreatedDate
    @Column(updatable = false)
    private LocalDate criadoEm;

    @LastModifiedDate
    private LocalDate atualizadoEm;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id")
    @Valid
    @JsonIgnoreProperties("estabelecimento")
    private EnderecoEstabelecimento enderecoEstabelecimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "horario_funcionamento_id")
    @Valid
    @JsonIgnoreProperties("estabelecimento")
    private HorarioFuncionamento horarioFuncionamento;
}
