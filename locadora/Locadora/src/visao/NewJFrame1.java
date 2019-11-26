/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.dao.ZonaDao;
import modelo.entidade.Zona;

/**
 *
 * @author James
 */
public class NewJFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        id = new javax.swing.JLabel();
        jTextCod = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JNome = new javax.swing.JTextField();
        jBExcluir = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        id.setText("Código:");

        jTextCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodActionPerformed(evt);
            }
        });

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        JNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNomeActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");

        jBEditar.setText("Editar");

        jBCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextCod, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBExcluir)
                                .addGap(27, 27, 27)
                                .addComponent(jBEditar)
                                .addGap(29, 29, 29)
                                .addComponent(jBCancelar))
                            .addComponent(JNome, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(jTextCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExcluir)
                    .addComponent(jBEditar)
                    .addComponent(jBCancelar))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCodActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
         // TODO add your handling code here:
        int id;
        Zona z ;
        
       id =  Integer.parseInt(jTextCod.getText());
        ZonaDao zd = new ZonaDao();
        try {
            
            z = zd.Buscar(id);
            if(z == null){
                JOptionPane.showMessageDialog(this, "não existe");
            }else{
            JNome.setText(z.getNome());    
            }
            //JOptionPane.showConfirmDialog(this, z.getNome());
            
        } catch (SQLException ex) {
             System.out.println("erro "+ex.getMessage());
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void JNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNomeActionPerformed
        
    }//GEN-LAST:event_JNomeActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JNome;
    private javax.swing.JLabel id;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextCod;
    // End of variables declaration//GEN-END:variables
}