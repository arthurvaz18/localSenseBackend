package com.localsense.localSense.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "endereco_estabelecimento")
@EntityListeners(AuditingEntityListener.class)
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
    @JsonIgnoreProperties("enderecoEstabelecimento") // evita loop
    private Estabelecimento estabelecimento;

    @OneToOne(mappedBy = "enderecoEstabelecimento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("enderecoEstabelecimento")
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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


