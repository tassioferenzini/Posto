/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import classes.relatorio;
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
public class ArquivoOutRelatorio {

    private FileOutputStream fout = null;
    private ObjectOutputStream objOut = null;
    private List<relatorio> lista = new ArrayList<relatorio>();

    public void abrir() throws FileNotFoundException, IOException { //throws, trata exceção para cada coisa que possa acontecer
        preparar();
        fout = new FileOutputStream("informacoes_es.txt");
        objOut = new ObjectOutputStream(fout);
        for (int i = 0; i < lista.size(); i++) {
            objOut.writeObject(lista.get(i));
        }
    }

    private void preparar() {
        ArquivoInRelatorio arq = new ArquivoInRelatorio();
        try {
            arq.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoOutRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoOutRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        relatorio cbt = null;
        while (continua) {
            try {
                cbt = arq.getescomb();
                if (cbt != null) {
                    lista.add(cbt);
                } else {
                    continua = false;
                }
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                Logger.getLogger(ArquivoOutRelatorio.class.getName()).log(Level.SEVERE, null, ex);
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoOutRelatorio.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        arq.fechar();
    }

    public void fechar() throws IOException {//throws, trata a exceção IOException
        objOut.close();
        fout.close();
    }

    public void Adicionar(relatorio cbr) throws IOException {
        objOut.writeObject(cbr);//grava o objeto todo
    }
}
