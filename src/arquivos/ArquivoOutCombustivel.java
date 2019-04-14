/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import classes.combustivel;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tassio
 */
public class ArquivoOutCombustivel {

    private FileOutputStream fout = null;
    private ObjectOutputStream objOut = null;
    private List<combustivel> lista = new ArrayList<combustivel>();

    public void abrir() throws FileNotFoundException, IOException { //throws, trata exceção para cada coisa que possa acontecer
        preparar();
        fout = new FileOutputStream("informacoes_combustivel.txt");
        objOut = new ObjectOutputStream(fout);
        for (int i = 0; i < lista.size(); i++) {
            objOut.writeObject(lista.get(i));
        }
    }

    private void preparar() {
        ArquivoInCombustivel arqcomb = new ArquivoInCombustivel();
        try {
            arqcomb.abrir();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoOutCombustivel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoOutCombustivel.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean continua = true;
        combustivel cbt = null;
        while (continua) {
            try {
                cbt = arqcomb.getCombustivel();
                if (cbt != null) {
                    lista.add(cbt);
                } else {
                    continua = false;
                }
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                Logger.getLogger(ArquivoOutCombustivel.class.getName()).log(Level.SEVERE, null, ex);
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoOutCombustivel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        arqcomb.fechar();
    }

    public void fechar() throws IOException {//throws, trata a exceção IOException
        objOut.close();
        fout.close();
    }

    public void Adicionar(combustivel cb) throws IOException {
        objOut.writeObject(cb);//grava o objeto todo
    }

    public void recadastrar_todos(ArrayList<combustivel> listac) throws IOException {
        fout = new FileOutputStream("informacoes_combustivel.txt");
        objOut = new ObjectOutputStream(fout);

        for (int i = 0; i < listac.size(); i++) {
            objOut.writeObject(listac.get(i));
        }

    }
}
