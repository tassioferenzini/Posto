/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jfrmCombustivel.java
 *
 * Created on 21/11/2011, 19:39:12
 */
package forms;

import arquivos.ArquivoInCombustivel;
import arquivos.ArquivoInTanque;
import arquivos.ArquivoOutCombustivel;
import classes.combustivel;
import classes.tanque;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tassio
 */
public class jfrmCombustivel extends javax.swing.JFrame {

    private ArquivoInCombustivel arqincombustivel = new ArquivoInCombustivel();
    private ArquivoInTanque arqintanque = new ArquivoInTanque();
    private combustivel cb = null;
    int linha;
    private ArquivoOutCombustivel arqoutcombustivel = new ArquivoOutCombustivel();

    /** Creates new form jfrmCombustivel */
    public jfrmCombustivel() {

        try {
            initComponents();
            arqoutcombustivel.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(jfrmCombustivel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(jfrmCombustivel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbcombustivel = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtlitroestoque = new javax.swing.JTextField();
        txttanque = new javax.swing.JTextField();
        jbtalterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabelacombustivel = new javax.swing.JTable();
        txtpreco = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtabelatanque = new javax.swing.JTable();
        jbtexcluir = new javax.swing.JButton();
        jbtadd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Combustivel");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Preço:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 20, 40, -1));

        jLabel2.setText("Litros em estoque:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 130, -1));

        jLabel3.setText("Combustivel:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 100, -1));

        jcbcombustivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gasolina", "Etanol", "Diesel" }));
        jcbcombustivel.setSelectedIndex(-1);
        jcbcombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbcombustivelActionPerformed(evt);
            }
        });
        jPanel1.add(jcbcombustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 130, -1));

        jLabel4.setText("Tanque:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 80, 20));
        jPanel1.add(txtlitroestoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 110, -1));

        txttanque.setEnabled(false);
        jPanel1.add(txttanque, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 50, -1));

        jbtalterar.setText("Alterar");
        jbtalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtalterarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtalterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 130, -1));

        jtabelacombustivel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Combustivel", "Preço", "Estoque", "Tanque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabelacombustivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelacombustivelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtabelacombustivel);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 127, 476, 110));

        try {
            txtpreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#,###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtpreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 120, -1));

        jtabelatanque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Capacidade", "Combustivel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabelatanque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelatanqueMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtabelatanque);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 476, 120));

        jbtexcluir.setText("Excluir");
        jbtexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtexcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jbtexcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 130, -1));

        jbtadd.setText("Adicionar");
        jbtadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtaddActionPerformed(evt);
            }
        });
        jPanel1.add(jbtadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 130, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 40, 60));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 60));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 30, 60));

        jTabbedPane1.addTab("Controle", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 430));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-590)/2, (screenSize.height-487)/2, 590, 487);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtaddActionPerformed
        int linhatanque = jtabelatanque.getSelectedRow();

        String nome = jcbcombustivel.getSelectedItem().toString();
        int litros = Integer.parseInt(txtlitroestoque.getText());


        String comb_tanque = jtabelatanque.getValueAt(linhatanque, 2).toString();
        int cap_tanque = Integer.parseInt(jtabelatanque.getValueAt(linhatanque, 1).toString());

        if (comb_tanque.equals(nome)) {
            if (litros <= cap_tanque) {

                cb = new combustivel(nome,
                        txtpreco.getText(),
                        Integer.parseInt(txtlitroestoque.getText()),
                        txttanque.getText());
                try {
                    arqoutcombustivel.Adicionar(cb);
                } catch (IOException ex) {
                    Logger.getLogger(jfrmCombustivel.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "Combustivel adicionado com sucesso");

                jcbcombustivel.setSelectedIndex(-1);
                txtlitroestoque.setText(null);
                txtpreco.setText(null);
                txttanque.setText(null);


                DefaultTableModel modelo = (DefaultTableModel) jtabelacombustivel.getModel();

                if (jtabelacombustivel.getRowCount() > 0) {
                    for (int i = jtabelacombustivel.getRowCount() - 1; i >= 0; i--) {
                        modelo.removeRow(i);
                    }
                }

                List<combustivel> listab2 = new ArrayList<combustivel>();
                listab2 = arqincombustivel.getTodoscombustiveis();

                for (int i = 0; i < listab2.size(); i++) {
                    modelo.addRow(listab2.get(i).getcombustivel());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Capacidade acima da disponivel no tanque");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Combustivel selecionado incompativel com o do tanque");
        }
    }//GEN-LAST:event_jbtaddActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


        List<combustivel> lista = new ArrayList<combustivel>();

        lista = arqincombustivel.getTodoscombustiveis();
        DefaultTableModel modelo = (DefaultTableModel) jtabelacombustivel.getModel();

        for (int i = jtabelacombustivel.getRowCount() - 1; i >= 0; --i) {
            modelo.removeRow(i);
        }

        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(lista.get(i).getcombustivel());
        }
        List<tanque> listatanque = new ArrayList<tanque>();
        int cont = 1;

        listatanque = arqintanque.getTodosTanque();
        DefaultTableModel modelotanque = (DefaultTableModel) jtabelatanque.getModel();

        for (int i = jtabelatanque.getRowCount() - 1; i >= 0; --i) {
            modelotanque.removeRow(i);
        }

        for (int i = 0; i < listatanque.size(); i++) {
            modelotanque.addRow(listatanque.get(i).gettanque());
        }


    }//GEN-LAST:event_formWindowOpened

    private void jtabelacombustivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelacombustivelMouseClicked



        linha = jtabelacombustivel.getSelectedRow();

        jcbcombustivel.setSelectedItem(jtabelacombustivel.getValueAt(linha, 0));
        txtpreco.setText(jtabelacombustivel.getValueAt(linha, 1).toString());
        txtlitroestoque.setText(jtabelacombustivel.getValueAt(linha, 2).toString());
        txttanque.setText(jtabelacombustivel.getValueAt(linha, 3).toString());

    }//GEN-LAST:event_jtabelacombustivelMouseClicked

    private void jbtexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtexcluirActionPerformed


        DefaultTableModel modelo = (DefaultTableModel) jtabelacombustivel.getModel();
        List<combustivel> list = new ArrayList<combustivel>();
        ArrayList<combustivel> nova_list = new ArrayList<combustivel>();
        linha = jtabelacombustivel.getSelectedRow();
        Object nome = modelo.getValueAt(linha, 0);
        list = arqincombustivel.getTodoscombustiveis();

        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i).getNome().equals(jcbcombustivel.getSelectedItem().toString()))) {
                nova_list.add(list.get(i));
            }
        }
        try {
            arqoutcombustivel.recadastrar_todos(nova_list);
        } catch (IOException ex) {
            Logger.getLogger(jfrmCombustivel.class.getName()).log(Level.SEVERE, null, ex);
        }
        jcbcombustivel.setSelectedIndex(-1);
        txtlitroestoque.setText(null);
        txtpreco.setText(null);
        txttanque.setText(null);
        modelo.removeRow(linha);
        JOptionPane.showMessageDialog(null, "Combustivel apagada com sucesso");

    }//GEN-LAST:event_jbtexcluirActionPerformed

    private void jbtalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtalterarActionPerformed
        int linhatanque = -1;
        linhatanque = jtabelatanque.getSelectedRow();

        ArrayList<combustivel> listac = new ArrayList<combustivel>();
        listac = (ArrayList<combustivel>) arqincombustivel.getTodoscombustiveis();


        String nome = jcbcombustivel.getSelectedItem().toString();
        String preco = txtpreco.getText();
        int litros = Integer.parseInt(txtlitroestoque.getText());
        String tanque = txttanque.getText();

        String comb_tanque = jtabelatanque.getValueAt(linhatanque, 2).toString();

        if (linhatanque != -1) {


            if (comb_tanque.equals(nome)) {



                listac.get(linha).setNome(nome);
                listac.get(linha).setPreco(preco);
                listac.get(linha).setLitros(litros);
                listac.get(linha).setTanque(tanque);
                try {
                    arqoutcombustivel.recadastrar_todos(listac);
                } catch (IOException ex) {
                    Logger.getLogger(jfrmCombustivel.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "Combustivel Alterado com Sucesso!");

                jcbcombustivel.setSelectedIndex(-1);
                txtlitroestoque.setText(null);
                txtpreco.setText(null);
                txttanque.setText(null);


                DefaultTableModel modelo = (DefaultTableModel) jtabelacombustivel.getModel();

                if (jtabelacombustivel.getRowCount() > 0) {
                    for (int i = jtabelacombustivel.getRowCount() - 1; i >= 0; i--) {
                        modelo.removeRow(i);
                    }
                }

                List<combustivel> listab2 = new ArrayList<combustivel>();
                listab2 = arqincombustivel.getTodoscombustiveis();

                for (int i = 0; i < listab2.size(); i++) {
                    modelo.addRow(listab2.get(i).getcombustivel());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Combustivel selecionado incompativel com o do tanque ");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não foi informado tanque");
        }

    }//GEN-LAST:event_jbtalterarActionPerformed
    private void jtabelatanqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelatanqueMouseClicked

        int linhatanque = jtabelatanque.getSelectedRow();

        txttanque.setText(jtabelatanque.getValueAt(linhatanque, 0).toString());

    }//GEN-LAST:event_jtabelatanqueMouseClicked

private void jcbcombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbcombustivelActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbcombustivelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


























                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfrmCombustivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmCombustivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmCombustivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmCombustivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new jfrmCombustivel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtadd;
    private javax.swing.JButton jbtalterar;
    private javax.swing.JButton jbtexcluir;
    private javax.swing.JComboBox jcbcombustivel;
    private javax.swing.JTable jtabelacombustivel;
    private javax.swing.JTable jtabelatanque;
    private javax.swing.JTextField txtlitroestoque;
    private javax.swing.JFormattedTextField txtpreco;
    private javax.swing.JTextField txttanque;
    // End of variables declaration//GEN-END:variables
}