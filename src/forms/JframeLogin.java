/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JframeLogin.java
 *
 * Created on 17/08/2011, 20:28:19
 */
package forms;

import javax.swing.JOptionPane;
import classes.login;
import java.awt.Color;
/**
 *
 * @author Tassio
 */
public class JframeLogin extends javax.swing.JFrame {

    /** Creates new form JframeLogin */
    public JframeLogin() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbrOK = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jtfSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Login:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jtfLogin.setText("admin");
        jtfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLoginActionPerformed(evt);
            }
        });
        jtfLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfLoginFocusLost(evt);
            }
        });
        getContentPane().add(jtfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Senha:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jbrOK.setText("OK");
        jbrOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbrOKActionPerformed(evt);
            }
        });
        getContentPane().add(jbrOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, -1));

        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });
        getContentPane().add(jbtSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 70, -1));

        jtfSenha.setText("admin123");
        getContentPane().add(jtfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, -1));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-225)/2, (screenSize.height-203)/2, 225, 203);
    }// </editor-fold>//GEN-END:initComponents

    private void jbrOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbrOKActionPerformed
        
        login log = new login();
        
        if (log.validarLogin(jtfLogin.getText()))
            if(log.validarSenha(jtfSenha.getText()))
                if(log.autenticar(jtfLogin.getText(), jtfSenha.getText())){
                    //JOptionPane.showMessageDialog(null, "Login Correto");
                    Principal janela1 = new Principal(); 
                    janela1.setVisible(true); // chama a janela principal
                    this.dispose(); // fecha somente esta janela de login
                } else
                    JOptionPane.showMessageDialog(null, "Login incorreto");
        else
                JOptionPane.showMessageDialog(null, "Senha incorreta");
        else
            JOptionPane.showMessageDialog(null, "usuário incorreto");
             
                    
    }//GEN-LAST:event_jbrOKActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jtfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfLoginActionPerformed
        jtfSenha.requestFocus();
        jtfSenha.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_jtfLoginActionPerformed

    private void jtfLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfLoginFocusLost
         jtfLogin.setBackground(Color.red);  // cor de fundo
    }//GEN-LAST:event_jtfLoginFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JframeLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbrOK;
    private javax.swing.JButton jbtSair;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JPasswordField jtfSenha;
    // End of variables declaration//GEN-END:variables
}