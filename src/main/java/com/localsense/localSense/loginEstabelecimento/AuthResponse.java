package com.localsense.localSense.loginEstabelecimento;

import java.util.UUID;

public class AuthResponse {
    private String token;
    private UUID idEstabelecimento;
    private String nomeEstabelecimento;

    public AuthResponse(String token, UUID idEstabelecimento, String nomeEstabelecimento) {
        this.token = token;
        this.idEstabelecimento = idEstabelecimento;
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UUID getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(UUID idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }
}
