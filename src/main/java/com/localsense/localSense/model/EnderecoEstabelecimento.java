package com.localsense.localSense.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "enderecoEstabelecimento")
@EntityListeners(AuditingEntityListener.class)
public class EnderecoEstabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String pais;

    @Column(nullable = false, length = 2)
    private String estado;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(nullable = false, length = 150)
    private String endereco;

    @Column(length = 150)
    private String complemento;

    @CreatedDate
    @Column(updatable = false)
    private LocalDate criadoEm;

    @LastModifiedDate
    private LocalDate atualizadoEm;

    @OneToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    @OneToOne(mappedBy = "enderecoEstabelecimento", cascade = CascadeType.ALL)
    private LocalizacaoEstabelecimento localizacaoEstabelecimento;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public LocalizacaoEstabelecimento getLocalizacaoEstabelecimento() {
        return localizacaoEstabelecimento;
    }

    public void setLocalizacaoEstabelecimento(LocalizacaoEstabelecimento localizacaoEstabelecimento) {
        this.localizacaoEstabelecimento = localizacaoEstabelecimento;
    }
}
