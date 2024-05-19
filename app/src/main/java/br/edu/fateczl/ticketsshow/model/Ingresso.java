package br.edu.fateczl.ticketsshow.model;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

public class Ingresso {
    private String identificacao;
    private float valor;

    public Ingresso() {
        super();
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float valorFinal(final float VALOR_TAXA) {
        return this.valor * VALOR_TAXA;
    }

    @NonNull
    @Override
    public String toString() {
        return  "Ingresso | Comum\n" +
                "ID: " + this.identificacao + '\n' +
                "Valor: " + formatVal() + '\n';
    }

    @SuppressLint("DefaultLocale")
    private String formatVal() {
        return String.format("%.2f", this.valor);
    }
}
