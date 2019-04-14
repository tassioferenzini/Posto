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
public class combustivel implements Serializable {

    private String nome;
    private String preco;
    private int litros;
    private String tanque;

    public combustivel(String nome, String preco, int litros, String tanque) {
        this.nome = nome;
        this.preco = preco;
        this.litros = litros;
        this.tanque = tanque;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public String getTanque() {
        return tanque;
    }

    public void setTanque(String tanque) {
        this.tanque = tanque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Object[] getcombustivel() {
        Object combustivel[] = {nome, preco, litros, tanque};
        return combustivel;
    }
}
