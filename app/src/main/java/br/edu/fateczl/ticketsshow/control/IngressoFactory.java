package br.edu.fateczl.ticketsshow.control;

import br.edu.fateczl.ticketsshow.model.Ingresso;

public interface IngressoFactory {
    static final float TAXA_CONVENIENCIA = 1.12f;//taxa fixa de conveniência de 12%

    Ingresso createIngresso(String id, float valor, String funcao);

    float getTaxaIngresso();
}
