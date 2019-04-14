/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author tassio
 */
public class tanque implements Serializable {

    private String numero_identificacao;
    private int capacidade;
    private String combustivel;
    
    public Object[] gettanque() {
        Object tanque[] = {numero_identificacao, capacidade, combustivel};
        return tanque;
    }

    public tanque(String numero_identificacao, int capacidade, String combustivel) {
        this.numero_identificacao = numero_identificacao;
        this.capacidade = capacidade;
        this.combustivel = combustivel;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getNumero_identificacao() {
        return numero_identificacao;
    }

    public void setNumero_identificacao(String numero_identificacao) {
        this.numero_identificacao = numero_identificacao;
    }
}
