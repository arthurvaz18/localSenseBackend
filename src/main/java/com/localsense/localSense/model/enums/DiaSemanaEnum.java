package com.localsense.localSense.model.enums;

public enum DiaSemanaEnum {
    DOMINGO(1),
    SEGUNDA(2),
    TERCA(3),
    QUARTA(4),
    QUINTA(5),
    SEXTA(6),
    SABADO(7);

    private final int valor;

    DiaSemanaEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
