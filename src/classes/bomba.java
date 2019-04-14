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
public class bomba implements Serializable {

    private String numero_bomba;
    private String tanque_vinculado;
    private String combustivel_bomba;

    public String getTanque_vinculado() {
        return tanque_vinculado;
    }

    public void setTanque_vinculado(String tanque_vinculado) {
        this.tanque_vinculado = tanque_vinculado;
    }

    public bomba(String numero_bomba, String tanque_vinculado, String combustivel_bomba) {
        this.numero_bomba = numero_bomba;
        this.tanque_vinculado = tanque_vinculado;
        this.combustivel_bomba = combustivel_bomba;
    }

    public String getCombustivel_bomba() {
        return combustivel_bomba;
    }

    public void setCombustivel_bomba(String combustivel_bomba) {
        this.combustivel_bomba = combustivel_bomba;
    }

    public String getNumero_bomba() {
        return numero_bomba;
    }

    public void setNumero_bomba(String numero_bomba) {
        this.numero_bomba = numero_bomba;
    }

    public Object[] getbomba() {
        Object bomba[] = {numero_bomba, tanque_vinculado, combustivel_bomba};
        return bomba;
    }
}
