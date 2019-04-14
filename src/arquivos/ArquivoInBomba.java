/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import classes.bomba;
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
public class ArquivoInBomba {//recura, le a informação

    private FileInputStream fin = null;
    private ObjectInputStream objIn = null;

    public void abrir() throws FileNotFoundException, IOException {
        fin = new FileInputStream("informacoes_bomba.txt");
        objIn = new ObjectInputStream(fin);

    }

    public void fechar() {
        try {
            objIn.close();
            fin.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInBomba.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public bomba getbomba() throws IOException, ClassNotFoundException {
        bomba b = null;

        try {
            b = (bomba) objIn.readObject();
        } catch (EOFException ex) {
            b = null;
        }
        return b;
    }

    public List getTodasBomba() {
        List<bomba> listabomba = new ArrayList<bomba>();

        try {
            this.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoInBomba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInBomba.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        bomba bmb = null;
        while (continua) {
            try {
                bmb = (bomba) objIn.readObject();
                listabomba.add(bmb);
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
        return listabomba;
    }
}
