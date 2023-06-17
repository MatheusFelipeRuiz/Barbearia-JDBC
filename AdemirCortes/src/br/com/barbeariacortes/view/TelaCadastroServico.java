/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.barbeariacortes.view;

import br.com.barbeariacortes.dao.ServicosDAO;
import br.com.barbeariacortes.dto.ServicoDTO;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TelaCadastroServico extends javax.swing.JFrame implements Utilitarios {

    private final TelaCadastroServico tl;

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastroServico() {
        initComponents();
        inserirLogo("../src/br/com/barbeariacortes/view/img/icone-login.png", this);
        setTitle("Cadastrar Usuário");
        setSize(700, 600);
        setResizable(false); // Define que não pode aumentar o tamanho da tela
        tl = this;
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

        heading = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        txtNomeServico = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtPreco = new javax.swing.JFormattedTextField();
        jLabelLimpar = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        heading.setForeground(new java.awt.Color(255, 255, 255));
        heading.setText("Cadastro Serviço");
        getContentPane().add(heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabelNome.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("Nome Serviço");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));
        getContentPane().add(txtNomeServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 300, -1));

        jLabelEmail.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("Descrição");
        getContentPane().add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        txtDescricao.setColumns(10);
        txtDescricao.setToolTipText("");
        getContentPane().add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 300, 50));

        jLabelUsuario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Preço");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        btnCadastrar.setBackground(new java.awt.Color(0, 0, 0));
        btnCadastrar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        btnLimpar.setBackground(new java.awt.Color(204, 0, 51));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/barbeariacortes/view/img/icone-limpar.png"))); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 40, -1));

        try {
            txtPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$ ###,## reais")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 140, -1));

        jLabelLimpar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabelLimpar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLimpar.setText("Limpar");
        getContentPane().add(jLabelLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/barbeariacortes/view/img/background-cadastro.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String nome = txtNomeServico.getText();
        String desc = txtDescricao.getText();
        String precoT = txtPreco.getText();
        String precoF = precoT.substring(3, 9);
        Float preco = -2F;
        if (nome.isEmpty() || desc.isEmpty() || precoT.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o nome e a descrição");
        } else {
            try {
                precoF = precoF.replaceAll(",", ".");
                preco = Float.parseFloat(precoF);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha o preço do serviço");
            }
            if (preco != -2) {
                ServicoDTO servicoDTO = new ServicoDTO(nome, desc, preco);
                cadastrarServico(servicoDTO);
            }
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelLimpar;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNomeServico;
    private javax.swing.JFormattedTextField txtPreco;
    // End of variables declaration//GEN-END:variables

    private void cadastrarServico(ServicoDTO servicoDTO) {
        ServicosDAO servicoDAO = new ServicosDAO();
        if (servicoDAO.cadastrarServico(servicoDTO)) {
            JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso");
            TelaServicosF telaServicos = new TelaServicosF();
            telaServicos.setVisible(true);
            tl.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar serviço");
        }
    }

    private void limparCampos() {
        txtNomeServico.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");

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