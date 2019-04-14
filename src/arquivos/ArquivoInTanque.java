/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import classes.tanque;
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
 * @author Tassio
 */
public class ArquivoInTanque {//recura, le a informação

    private FileInputStream fin = null;
    private ObjectInputStream objIn = null;

    public void abrir() throws FileNotFoundException, IOException {
        fin = new FileInputStream("informacoes_tanque.txt");
        objIn = new ObjectInputStream(fin);

    }

    public void fechar() {
        try {
            objIn.close();
            fin.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInTanque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public tanque gettanque() throws IOException, ClassNotFoundException {
        tanque t = null;

        try {
            t = (tanque) objIn.readObject();
        } catch (EOFException ex) {
            t = null;
        }
        return t;
    }

    public List getTodosTanque() {
        List<tanque> lista = new ArrayList<tanque>();

        try {
            abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoInTanque.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInTanque.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        tanque tq = null;
        while (continua) {
            try {
                tq = (tanque) objIn.readObject();
                lista.add(tq);
            } catch (EOFException ex) {
                continua = false;
                //Logger.getLogger(ArquivoInTanque.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                continua = false;
                //Logger.getLogger(ArquivoInTanque.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //continua = false;
                //Logger.getLogger(ArquivoInTanque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fechar();
        return lista;
    }
}
