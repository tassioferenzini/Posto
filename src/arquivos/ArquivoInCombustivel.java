/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import classes.combustivel;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tassio
 */
public class ArquivoInCombustivel {//recura, le a informação

    private FileInputStream fin = null;
    private ObjectInputStream objIn = null;

    public void abrir() throws FileNotFoundException, IOException {
        fin = new FileInputStream("informacoes_combustivel.txt");
        objIn = new ObjectInputStream(fin);

    }

    public void fechar() {
        try {
            objIn.close();
            fin.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInCombustivel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public combustivel getCombustivel() throws IOException, ClassNotFoundException {
        combustivel c = null;

        try {
            c = (combustivel) objIn.readObject();
        } catch (EOFException ex) {
            c = null;
        }
        return c;
    }

    public List getTodoscombustiveis() {
        List<combustivel> lista = new ArrayList<combustivel>();

        try {
            abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoInCombustivel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInCombustivel.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        combustivel cbt = null;
        while (continua) {
            try {
                cbt = (combustivel) objIn.readObject();
                lista.add(cbt);
            } catch (EOFException ex) {
                continua = false;
                //Logger.getLogger(ArquivoInCombustivel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                continua = false;
                //Logger.getLogger(ArquivoInCombustivel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //continua = false;
                //Logger.getLogger(ArquivoInCombustivel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fechar();
        return lista;
    }
}
