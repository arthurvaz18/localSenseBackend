package com.localsense.localSense.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "estabelecimento")
@EntityListeners(AuditingEntityListener.class)
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome_fantasia", length = 150)
    private String nomeFantasia;

    @Column(name = "razao_social", length = 150)
    private String razaoSocial;

    @Column(name = "cnpj", length = 14, unique = true, nullable = false)
    private String cnpj;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Column(name = "status")
    private Boolean status;

    @OneToOne(mappedBy = "endereco_Estabelecimento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EnderecoEstabelecimento enderecoEstabelecimento;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "midias", columnDefinition = "JSONB")
    private List<String> midias;

    @CreatedDate
    @Column(updatable = false)
    private LocalDate criadoEm;

    @LastModifiedDate
    private LocalDate atualizadoEm;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public EnderecoEstabelecimento getEnderecoEstabelecimento() {
        return enderecoEstabelecimento;
    }

    public void setEnderecoEstabelecimento(EnderecoEstabelecimento enderecoEstabelecimento) {
        this.enderecoEstabelecimento = enderecoEstabelecimento;
    }

    public List<String> getMidias() {
        return midias;
    }

    public void setMidias(List<String> midias) {
        this.midias = midias;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDate getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDate atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
