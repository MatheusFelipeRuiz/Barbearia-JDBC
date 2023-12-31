/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.barbeariacortes.view;

import br.com.barbeariacortes.dao.FuncionarioDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class TelaFuncionarios extends javax.swing.JFrame implements Utilitarios {

    private final TelaFuncionarios tl;

    /**
     * Creates new form TelaFuncionarios
     */
    public TelaFuncionarios() {
        initComponents();
        tl = this;
        setTitle("Lista de funcionários");
        inserirLogo("../src/br/com/barbeariacortes/view/img/icone-funcionarios.png", tl);
        preencherFuncionarios(tl);
        setSize(700, 500);
        setResizable(false); // Define que não pode aumentar o tamanho da tela
        alinharTela(tl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tableFuncionario = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        heading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cargo", "Nome Completo"
            }
        ));
        tblFuncionario.setEnabled(false);
        tableFuncionario.setViewportView(tblFuncionario);
        if (tblFuncionario.getColumnModel().getColumnCount() > 0) {
            tblFuncionario.getColumnModel().getColumn(0).setMinWidth(100);
            tblFuncionario.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        heading.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        heading.setForeground(new java.awt.Color(255, 255, 255));
        heading.setText("Lista de funcionários do estabelecimento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(heading))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(tableFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(heading)
                .addGap(37, 37, 37)
                .addComponent(tableFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel heading;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane tableFuncionario;
    private javax.swing.JTable tblFuncionario;
    // End of variables declaration//GEN-END:variables

    private void preencherFuncionarios(TelaFuncionarios telaFuncionarios) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.preencherTabelaFuncionarios(telaFuncionarios);
    }

    public JTable getTblFuncionario() {
        return tblFuncionario;
    }

    public void setTblFuncionario(JTable tblFuncionario) {
        this.tblFuncionario = tblFuncionario;
    }

    @Override
    public void inserirLogo(String pathLogo, JFrame tela) {
        tela.setIconImage(Toolkit.getDefaultToolkit().getImage(pathLogo));
    }

    @Override
    public void alinharTela(JFrame jframe) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int frameWidth = jframe.getWidth();
        int frameHeight = jframe.getHeight();
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;

        jframe.setLocation(x, y);
    }

}
