/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import classes.tanque;
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
 * @author Tassio
 */
public class ArquivoOutTanque {

    private FileOutputStream fout = null;
    private ObjectOutputStream objOut = null;
    private List<tanque> lista = new ArrayList<tanque>();

    public void abrir() throws FileNotFoundException, IOException { //throws, trata exceção para cada coisa que possa acontecer
        preparar();
        fout = new FileOutputStream("informacoes_tanque.txt");
        objOut = new ObjectOutputStream(fout);
        for (int i = 0; i < lista.size(); i++) {
            objOut.writeObject(lista.get(i));
        }
    }

    private void preparar() {
        ArquivoInTanque arq = new ArquivoInTanque();
        try {
            arq.abrir();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoOutTanque.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoOutTanque.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean continua = true;
        tanque tq = null;
        while (continua) {
            try {
                tq = arq.gettanque();
                if (tq != null) {
                    lista.add(tq);
                } else {
                    continua = false;
                }
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                Logger.getLogger(ArquivoOutTanque.class.getName()).log(Level.SEVERE, null, ex);
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoOutTanque.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        arq.fechar();
    }

    public void fechar() throws IOException {//throws, trata a exceção IOException
        objOut.close();
        fout.close();
    }

    public void Adicionar(tanque tq) throws IOException {
        objOut.writeObject(tq);//grava o objeto todo
    }

    public void recadastrar_todos(ArrayList<tanque> listat) throws IOException {
        fout = new FileOutputStream("informacoes_tanque.txt");
        objOut = new ObjectOutputStream(fout);

        for (int i = 0; i < listat.size(); i++) {
            objOut.writeObject(listat.get(i));
        }

    }
}
