package br.edu.fateczl.ticketsshow.control;

import br.edu.fateczl.ticketsshow.model.Ingresso;

public class IngressoController implements IngressoFactory{
    @Override
    public Ingresso createIngresso(String id, float valor, String funcao) {
        Ingresso ticket = new Ingresso();
        ticket.setIdentificacao(id);
        ticket.setValor(valor);
        return ticket;
    }

    @Override
    public float getTaxaIngresso() {
        return TAXA_CONVENIENCIA;
    }
}
