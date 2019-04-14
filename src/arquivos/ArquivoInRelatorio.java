/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import classes.relatorio;
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
public class ArquivoInRelatorio {//recura, le a informação

    private FileInputStream fin = null;
    private ObjectInputStream objIn = null;

    public void abrir() throws FileNotFoundException, IOException {
        fin = new FileInputStream("informacoes_es.txt");
        objIn = new ObjectInputStream(fin);

    }

    public void fechar() {
        try {
            objIn.close();
            fin.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public relatorio getescomb() throws IOException, ClassNotFoundException {
        relatorio r = null;

        try {
            r = (relatorio) objIn.readObject();
        } catch (EOFException ex) {
            r = null;
        }
        return r;
    }

    public List getTodasESComb() {
        List<relatorio> listaes = new ArrayList<relatorio>();

        try {
            this.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoInBomba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInBomba.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        relatorio esc = null;
        while (continua) {
            try {
                esc = (relatorio) objIn.readObject();
                listaes.add(esc);
            } catch (EOFException ex) {
                continua = false;
                //Logger.getLogger(ArquivoInBomba.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                continua = false;
                //Logger.getLogger(ArquivoInBomba.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //continua = false;
                //Logger.getLogger(ArquivoInBomba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fechar();
        return listaes;
    }
}
