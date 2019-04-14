/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import classes.bomba;
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
public class ArquivoOutBomba {

    private FileOutputStream fout = null;
    private ObjectOutputStream objOut = null;
    private List<bomba> lista = new ArrayList<bomba>();

    public void abrir() throws FileNotFoundException, IOException { //throws, trata exceção para cada coisa que possa acontecer
        preparar();
        fout = new FileOutputStream("informacoes_bomba.txt");
        objOut = new ObjectOutputStream(fout);
        for (int i = 0; i < lista.size(); i++) {
            objOut.writeObject(lista.get(i));
        }
    }

    private void preparar() {
        ArquivoInBomba arq = new ArquivoInBomba();
        try {
            arq.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoOutBomba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoOutBomba.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        bomba bmb = null;
        while (continua) {
            try {
                bmb = arq.getbomba();
                if (bmb != null) {
                    lista.add(bmb);
                } else {
                    continua = false;
                }
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                Logger.getLogger(ArquivoOutBomba.class.getName()).log(Level.SEVERE, null, ex);
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoOutBomba.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        arq.fechar();
    }

    public void fechar() throws IOException {//throws, trata a exceção IOException
        objOut.close();
        fout.close();
    }

    public void Adicionar(bomba bmb) throws IOException {
        objOut.writeObject(bmb);//grava o objeto todo
    }

    public void recadastrar_todos(ArrayList<bomba> listab) throws IOException {
        fout = new FileOutputStream("informacoes_bomba.txt");
        objOut = new ObjectOutputStream(fout);

        for (int i = 0; i < listab.size(); i++) {
            objOut.writeObject(listab.get(i));
        }

    }
}
