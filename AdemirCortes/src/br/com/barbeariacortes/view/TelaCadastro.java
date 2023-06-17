/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.barbeariacortes.view;

import br.com.barbeariacortes.dto.Usuario;
import br.ce.orlando.gerador.cpf.ValidadorCPF;
import br.com.barbeariacortes.dao.ClienteDAO;
import br.com.barbeariacortes.dto.ClienteDTO;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TelaCadastro extends javax.swing.JFrame implements Utilitarios {

    private final TelaCadastro tl;

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
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
        txtNomeCompleto = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabelCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAjuda = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        heading.setForeground(new java.awt.Color(255, 255, 255));
        heading.setText("Cadastro cliente");
        getContentPane().add(heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabelNome.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("Nome Completo");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));
        getContentPane().add(txtNomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 300, -1));

        jLabelEmail.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("E-mail");
        getContentPane().add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 300, -1));

        jLabelUsuario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Nome de Usuário");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));
        getContentPane().add(txtNomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 300, -1));

        jLabelSenha.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelSenha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSenha.setText("Senha");
        getContentPane().add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 300, -1));

        jLabelCPF.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelCPF.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCPF.setText("CPF");
        getContentPane().add(jLabelCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 300, -1));

        btnCadastrar.setBackground(new java.awt.Color(255, 0, 0));
        btnCadastrar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, -1, -1));

        btnAjuda.setBackground(new java.awt.Color(51, 255, 0));
        btnAjuda.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnAjuda.setForeground(new java.awt.Color(255, 255, 255));
        btnAjuda.setText("Ajuda");
        btnAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjudaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAjuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/barbeariacortes/view/img/background-cadastro.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String nomeCompleto = txtNomeCompleto.getText();
        String email = txtEmail.getText().toLowerCase();
        String nomeUsuario = txtNomeUsuario.getText();
        String senha = txtPassword.getText();
        String cpf = txtCPF.getText();

        if (nomeCompleto.isEmpty() || email.isEmpty() || nomeUsuario.isEmpty() || senha.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
        } else if (!Usuario.emailValidator(email)) {
            JOptionPane.showMessageDialog(null, "E-mail inválido, por favor digite novamente");
        } else if (!ValidadorCPF.validaCPF(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF Inválido, por favor digite um válido");
        } else {
            ClienteDTO clienteDTO = new ClienteDTO(nomeUsuario, nomeCompleto, email, cpf, senha);
            ClienteDAO clienteDAO = new ClienteDAO();

            if (clienteDAO.cadastrarCliente(clienteDTO)) {
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);

                tl.dispose();
            }

            limparCampos();

        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjudaActionPerformed
        TelaContato telaContato = new TelaContato();
        telaContato.setVisible(true);

    }//GEN-LAST:event_btnAjudaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAjuda;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNomeCompleto;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    private boolean eCampoVazio(String campo) {
        if (campo.isEmpty()) {
            return true;
        }
        return false;
    }

    private void limparCampos() {
        txtNomeCompleto.setText("");
        txtEmail.setText("");
        txtCPF.setText("");
        txtNomeUsuario.setText("");
        txtPassword.setText("");
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
