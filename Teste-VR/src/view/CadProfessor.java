/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.ProfessorDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Professor;

/**
 *
 * @author usr
 */
public class CadProfessor extends javax.swing.JFrame {

    /**
     * Creates new form Professor
     */
    public CadProfessor() throws SQLException {
        initComponents();
        setLocationRelativeTo( null );
        Listar();
    }
    
    private void clean(){
        jtxtNome.setText(null);
        jTXTCPF.setText(null);
        jTXTRG.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProf = new javax.swing.JTable();
        jBtIncluir = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtxtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTXTRG = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTXTCPF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboTitulo = new javax.swing.JComboBox<>();
        jbFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTableProf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "RG", "CPF", "Título"
            }
        ));
        jTableProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProfMouseClicked(evt);
            }
        });
        jTableProf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableProfKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProf);

        jBtIncluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtIncluir.setText("Incluir");
        jBtIncluir.setName("btIncluir"); // NOI18N
        jBtIncluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtIncluirMouseClicked(evt);
            }
        });

        jBtAlterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setName("btAlterar"); // NOI18N
        jBtAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtAlterarMouseClicked(evt);
            }
        });

        jBtExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setName("btAlterar"); // NOI18N
        jBtExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtExcluirMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("RG:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("CPF:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Título:");

        jComboTitulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doutor", "Mestre" }));

        jbFechar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbFechar.setText("Fechar");
        jbFechar.setName("btAlterar"); // NOI18N
        jbFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbFecharMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBtIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTXTRG, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTXTCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxtNome))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTXTRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTXTCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIncluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtIncluirMouseClicked
        // TODO add your handling code here:
        Professor p = new Professor(jtxtNome.getText(),
                            jTXTRG.getText(),
                            jTXTCPF.getText(),
                            jComboTitulo.getSelectedItem().toString()
                            );
        
        ProfessorDAO pd = new ProfessorDAO();
        try {
            pd.insereProfessor(p);
            
            Listar();
        } catch (SQLException ex) {
            Logger.getLogger(CadProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        clean();
    }//GEN-LAST:event_jBtIncluirMouseClicked

    private void jBtAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtAlterarMouseClicked
        // TODO add your handling code here:
        
        if (jTableProf.getSelectedRow() != -1){

            Professor p = new Professor(0);
            
            ProfessorDAO pa = new ProfessorDAO();
            
            p.setNome(jtxtNome.getText());
            p.setRg(jTXTRG.getText());
            p.setCpf(jTXTCPF.getText());
            p.setTitulo(jComboTitulo.getSelectedItem().toString());
            p.setCodigo((int) jTableProf.getValueAt(jTableProf.getSelectedRow(), 0));
            
            try {
                pa.atualizaProfessor(p);
                Listar();
            } catch (SQLException ex) {
                Logger.getLogger(CadProfessor.class.getName()).log(Level.SEVERE, null, ex);
            }
            clean();
        }
    }//GEN-LAST:event_jBtAlterarMouseClicked

    private void jTableProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProfMouseClicked
        // TODO add your handling code here:
        Refresh();
    }//GEN-LAST:event_jTableProfMouseClicked

    private void jTableProfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableProfKeyReleased
        // TODO add your handling code here:
        Refresh();
    }//GEN-LAST:event_jTableProfKeyReleased

    private void jBtExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtExcluirMouseClicked
        // TODO add your handling code here:
        
        if (jTableProf.getSelectedRow() != -1){

            Professor p = new Professor(0);
            
            ProfessorDAO pa = new ProfessorDAO();
            
            p.setCodigo((int) jTableProf.getValueAt(jTableProf.getSelectedRow(), 0));

            try {
                pa.deletaProfessor(p);
                Listar();
            } catch (SQLException ex) {
                Logger.getLogger(CadProfessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtExcluirMouseClicked

    private void jbFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbFecharMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbFecharMouseClicked

    private void Refresh() {
        if (jTableProf.getSelectedRow() != -1){
            
            jtxtNome.setText(jTableProf.getValueAt(jTableProf.getSelectedRow(), 1).toString());
            jTXTRG.setText(jTableProf.getValueAt(jTableProf.getSelectedRow(), 2).toString());
            jTXTCPF.setText(jTableProf.getValueAt(jTableProf.getSelectedRow(), 3).toString());
            jComboTitulo.setSelectedItem(jTableProf.getValueAt(jTableProf.getSelectedRow(), 4).toString());
        }
    }
    
    public void Listar() throws SQLException{
    
        DefaultTableModel modelo = (DefaultTableModel) jTableProf.getModel();
        ProfessorDAO pd = new ProfessorDAO();
        modelo.setRowCount(0);
        
        for (Professor p : pd.Listar()) {
            
             modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getNome(),
                p.getRg(),
                p.getCpf(),
                p.getTitulo()
             }
             );   
        }
    }
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
            java.util.logging.Logger.getLogger(CadProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadProfessor().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadProfessor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtIncluir;
    private javax.swing.JComboBox<String> jComboTitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTXTCPF;
    private javax.swing.JTextField jTXTRG;
    private javax.swing.JTable jTableProf;
    private javax.swing.JButton jbFechar;
    private javax.swing.JTextField jtxtNome;
    // End of variables declaration//GEN-END:variables
}
