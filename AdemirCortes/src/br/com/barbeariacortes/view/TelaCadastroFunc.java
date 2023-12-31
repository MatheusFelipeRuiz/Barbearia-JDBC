/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.barbeariacortes.view;

import br.ce.orlando.gerador.cpf.ValidadorCPF;
import br.com.barbeariacortes.dao.FuncionarioDAO;

import br.com.barbeariacortes.dto.FuncionarioDTO;
import br.com.barbeariacortes.dto.Usuario;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TelaCadastroFunc extends javax.swing.JFrame implements Utilitarios {

    private final TelaCadastroFunc tl;

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastroFunc() {
        initComponents();
        inserirLogo("../src/br/com/barbeariacortes/view/img/icone-login.png", this);
        setTitle("Cadastrar Usuário");
        setSize(700, 600);
        setResizable(false); // Define que não pode aumentar o tamanho da tela
        tl = this;
        preencherComboBox();
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
        jLabelCategoria = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabelSenha = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabelCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabelSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JFormattedTextField();
        btnCadastrar = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        heading.setForeground(new java.awt.Color(255, 255, 255));
        heading.setText("Cadastro funcionário");
        getContentPane().add(heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

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

        jLabelCategoria.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCategoria.setText("Categoria");
        getContentPane().add(jLabelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        getContentPane().add(jComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 160, -1));

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

        jLabelSalario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelSalario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSalario.setText("Salário");
        getContentPane().add(jLabelSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, -1, -1));

        try {
            txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$ #.###,## reais")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 160, -1));

        btnCadastrar.setBackground(new java.awt.Color(255, 0, 0));
        btnCadastrar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/barbeariacortes/view/img/background-cadastro.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        String nomeCompleto = txtNomeCompleto.getText();
        String email = txtEmail.getText().toLowerCase();
        String senha = txtPassword.getText();
        if (!ValidadorCPF.validaCPF(txtCPF.getText())) {
            JOptionPane.showMessageDialog(null, "Digite um CPF válido");
        } else if (!Usuario.emailValidator(email)) {
            JOptionPane.showMessageDialog(null, "Digite um e-mail válido");
        } else {
            String cpf = txtCPF.getText();
            String categoria = tl.getjComboBoxCategoria().getSelectedItem().toString();
            int idCategoria = funcionarioDAO.getCategoriaFuncionario(categoria);

            String salario = txtSalario.getText().replaceAll("[^\\d,.-]", "");
            salario = salario.replaceAll(",", ".");
            salario = salario.replaceFirst("\\.", "");

            if (salario.length() < 7) {
                JOptionPane.showMessageDialog(null, "Por favor,preencha  o salário corretamente");
            } else {

                Float salarioF = Float.parseFloat(salario);

                if (nomeCompleto.isEmpty() || senha.isEmpty() || cpf.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos");
                } else {
                    FuncionarioDTO funcionarioDTO = new FuncionarioDTO(nomeCompleto, email, cpf, senha, salarioF, idCategoria);
                    funcionarioDAO.cadastrarFuncionario(funcionarioDTO);
                    JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");
                    tl.dispose();
                }
            }
        }


    }//GEN-LAST:event_btnCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroFunc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel heading;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSalario;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNomeCompleto;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JFormattedTextField txtSalario;
    // End of variables declaration//GEN-END:variables

    private void preencherComboBox() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.preencherComboBoxCategoria(tl);
    }

    private void limparCampos() {
        txtNomeCompleto.setText("");
        txtEmail.setText("");
        txtCPF.setText("");
        txtSalario.setText("");
        txtPassword.setText("");
    }

    public JComboBox<String> getjComboBoxCategoria() {
        return jComboBoxCategoria;
    }

    public void setjComboBoxCategoria(JComboBox<String> jComboBoxCategoria) {
        this.jComboBoxCategoria = jComboBoxCategoria;
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
