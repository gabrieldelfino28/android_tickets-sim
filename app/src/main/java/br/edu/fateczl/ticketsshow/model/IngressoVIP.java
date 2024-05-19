package br.edu.fateczl.ticketsshow.model;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

public class IngressoVIP extends Ingresso {
    private String funcao;

    public IngressoVIP() {
        super();
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public float valorFinal(final float VALOR_TAXA) {
        return (getValor() * VALOR_TAXA) * 1.18f;
    }

    @NonNull
    @Override
    public String toString() {
        return  "Ingresso | VIP\n" +
                "ID: " + getIdentificacao() + '\n' +
                "Valor: " + getValor() + '\n' +
                "Função: " + formatVal() + '\n';
    }

    @SuppressLint("DefaultLocale")
    private String formatVal() {
        return String.format("%.2f", getValor());
    }

}
