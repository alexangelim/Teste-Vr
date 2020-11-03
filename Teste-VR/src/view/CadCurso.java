/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.CursoDAO;
import DAO.ProfessorDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Curso;

/**
 *
 * @author usr
 */
public class CadCurso extends javax.swing.JFrame {

    /**
     * Creates new form CadCurso
     */
    public CadCurso() throws SQLException {
        initComponents();
        setLocationRelativeTo( null );
        Inicio();
    }
    
    public void Inicio() throws SQLException{
        Listar();
        refreshCombo();
        clean();
    }
    
    public void refreshCombo() throws SQLException{
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cbProfessor.getModel();
        ProfessorDAO pd = new ProfessorDAO();
        
        for (model.Professor p : pd.readMestre()){ 
            comboBoxModel.addElement(p.getCodigo() + " - " +  p.getNome());    
        }
    }
    
    private void clean(){
        jTXTDescricao.setText(null);
        jTXTCarga.setText(null);
        jTXTDuracao.setText(null);
        jTxtQtdAluno.setText(null);
        cbProfessor.setSelectedIndex(-1);
    }
    
    private void verificaCampos() {
        
        if (jTXTDescricao.getText()==null){
            JOptionPane.showMessageDialog(null, "Favor informar a descrição");
            return;
        }else if(jTXTDuracao.getText()==null){
            JOptionPane.showMessageDialog(null, "Favor informar a duração");
            return;
        }else if(jTXTCarga.getText()==null){
            JOptionPane.showMessageDialog(null, "Favor informar a carga horária");
            return;
        }else if(jTxtQtdAluno.getText()==null){
            JOptionPane.showMessageDialog(null, "Favor informar a quantidade de alunos");
            return;
        }
        
        if ("".equals(cbPeriodo.getSelectedItem()+"")){
          JOptionPane.showMessageDialog(null, "Favor informar o periodo da disciplina");
          return;
        }
        
        if ("".equals(cbProfessor.getSelectedItem()+"")){
          JOptionPane.showMessageDialog(null, "Favor informar professor mestre ou doutor responsável");
          return;
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCurso = new javax.swing.JTable();
        jBtIncluir = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTXTDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTXTDuracao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTXTCarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbPeriodo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbProfessor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTxtQtdAluno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTableCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Duração", "Período", "Qtd. Alunos", "Carga Horária"
            }
        ));
        jTableCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCursoMouseClicked(evt);
            }
        });
        jTableCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCursoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCurso);

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

        jBtExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setName("btAlterar"); // NOI18N
        jBtExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtExcluirMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Descrição:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Duração:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Carga Horária:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Período:");

        cbPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino", "Noturno", "Integral" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Professor:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Qtd. Aluno");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBtIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTXTCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTXTDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtQtdAluno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTXTDuracao, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(cbPeriodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTXTDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTXTDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtQtdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTXTCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jBtExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtIncluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIncluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtIncluirMouseClicked
        // TODO add your handling code here:
        verificaCampos();
                
        Curso c = new Curso(jTXTDescricao.getText(),
                            jTXTDuracao.getText(),
                            cbPeriodo.getSelectedItem().toString(),
                            Integer.parseInt(jTxtQtdAluno.getText()),
                            Integer.parseInt(jTXTCarga.getText()),
                            cbProfessor.getSelectedIndex()+1);
        
        CursoDAO cd = new CursoDAO();
        try {
            cd.insereCurso(c);
            
            Listar();
        } catch (SQLException ex) {
            Logger.getLogger(CadProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        clean();
    }//GEN-LAST:event_jBtIncluirMouseClicked

    private void RefreshCampos() {
        if (jTableCurso.getSelectedRow() != -1){
            
            jTXTDescricao.setText(jTableCurso.getValueAt(jTableCurso.getSelectedRow(), 1).toString());
            jTXTDuracao.setText(jTableCurso.getValueAt(jTableCurso.getSelectedRow(), 2).toString());
            cbPeriodo.setSelectedItem(jTableCurso.getValueAt(jTableCurso.getSelectedRow(), 3).toString());
            jTxtQtdAluno.setText(jTableCurso.getValueAt(jTableCurso.getSelectedRow(), 4).toString());
            jTXTCarga.setText(jTableCurso.getValueAt(jTableCurso.getSelectedRow(), 5).toString());
        }
    }
    
    private void jBtExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtExcluirMouseClicked
        // TODO add your handling code here:
        if (jTableCurso.getSelectedRow() != -1){

            Curso c = new Curso(0);
            
            CursoDAO cd = new CursoDAO();
            
            c.setCodigo((int) jTableCurso.getValueAt(jTableCurso.getSelectedRow(), 0));

            try {
                cd.deletaCurso(c);
            } catch (SQLException ex) {
                Logger.getLogger(CadCurso.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Listar();
                
            } catch (SQLException ex) {
                Logger.getLogger(CadCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtExcluirMouseClicked

    private void jTableCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCursoMouseClicked
        // TODO add your handling code here:
        RefreshCampos();
    }//GEN-LAST:event_jTableCursoMouseClicked

    private void jTableCursoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCursoKeyReleased
        // TODO add your handling code here:
        RefreshCampos();
    }//GEN-LAST:event_jTableCursoKeyReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked
    
    public void Listar() throws SQLException{
    
        DefaultTableModel modelo = (DefaultTableModel) jTableCurso.getModel();
        CursoDAO cd = new CursoDAO();
        modelo.setRowCount(0);
        
        for (Curso c : cd.Listar()) {
            
             modelo.addRow(new Object[]{
                c.getCodigo(),
                c.getDescricao(),
                c.getDuracao(),
                c.getPeriodo(),
                c.getQtdAluno(),
                c.getCargaHoraria()
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
            java.util.logging.Logger.getLogger(CadCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadCurso().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadCurso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbPeriodo;
    private javax.swing.JComboBox<String> cbProfessor;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtIncluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTXTCarga;
    private javax.swing.JTextField jTXTDescricao;
    private javax.swing.JTextField jTXTDuracao;
    private javax.swing.JTable jTableCurso;
    private javax.swing.JTextField jTxtQtdAluno;
    // End of variables declaration//GEN-END:variables
}
