package br.edu.fateczl.ticketsshow.control;

import br.edu.fateczl.ticketsshow.model.Ingresso;
import br.edu.fateczl.ticketsshow.model.IngressoVIP;

public class IngressoVIPController implements IngressoFactory {

    @Override
    public Ingresso createIngresso(String id, float valor, String funcao) {
        IngressoVIP ticket = new IngressoVIP();
        ticket.setIdentificacao(id);
        ticket.setValor(valor);
        ticket.setFuncao(funcao);
        return ticket;
    }

    @Override
    public float getTaxaIngresso() {
        return TAXA_CONVENIENCIA;
    }
}
