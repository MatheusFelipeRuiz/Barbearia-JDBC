/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.barbeariacortes.view;

import br.com.barbeariacortes.dao.AgendaDAO;
import br.com.barbeariacortes.dao.ClienteDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TelaPrincipal extends javax.swing.JFrame implements Utilitarios {

    private final TelaPrincipal tl;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setTitle("Principal");
        tl = this;
        inserirLogo("../src/br/com/barbeariacortes/view/img/icone-home.png", tl);
        setSize(700, 700);
        setResizable(false); 
        alinharTela(tl);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgendar1 = new javax.swing.JButton();
        btnServicos = new javax.swing.JButton();
        jLabelBemVindo = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        background = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        itemUsuario = new javax.swing.JMenu();
        optionInformacoes = new javax.swing.JMenuItem();
        itemServico = new javax.swing.JMenu();
        optionServicos = new javax.swing.JMenuItem();
        optionAgendamento = new javax.swing.JMenuItem();
        itemSobreNos = new javax.swing.JMenu();
        optionFaleConosco = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgendar1.setBackground(new java.awt.Color(102, 102, 102));
        btnAgendar1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnAgendar1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendar1.setText("Agendar");
        btnAgendar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 110, -1));

        btnServicos.setBackground(new java.awt.Color(0, 0, 0));
        btnServicos.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnServicos.setForeground(new java.awt.Color(255, 255, 255));
        btnServicos.setText("Serviços");
        btnServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicosActionPerformed(evt);
            }
        });
        getContentPane().add(btnServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 30));

        jLabelBemVindo.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabelBemVindo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBemVindo.setText("Bem-vindo, ");
        getContentPane().add(jLabelBemVindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtNomeUsuario.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        txtNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtNomeUsuario.setText("Nome Usuário");
        getContentPane().add(txtNomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        btnSair.setBackground(new java.awt.Color(255, 0, 0));
        btnSair.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 110, -1));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/barbeariacortes/view/img/background-tela-inicial.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        itemUsuario.setText("Usuário");

        optionInformacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/barbeariacortes/view/img/icon-info.png"))); // NOI18N
        optionInformacoes.setText("Informações");
        optionInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionInformacoesActionPerformed(evt);
            }
        });
        itemUsuario.add(optionInformacoes);

        jMenuBar.add(itemUsuario);

        itemServico.setText("Serviços");

        optionServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/barbeariacortes/view/img/icone-tesoura.png"))); // NOI18N
        optionServicos.setText("Serviços");
        optionServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionServicosActionPerformed(evt);
            }
        });
        itemServico.add(optionServicos);

        optionAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/barbeariacortes/view/img/icon-calendario.png"))); // NOI18N
        optionAgendamento.setText("Agendamento");
        optionAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionAgendamentoActionPerformed(evt);
            }
        });
        itemServico.add(optionAgendamento);

        jMenuBar.add(itemServico);

        itemSobreNos.setText("Sobre nós");
        itemSobreNos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSobreNosActionPerformed(evt);
            }
        });

        optionFaleConosco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/barbeariacortes/view/img/icon-telefone.png"))); // NOI18N
        optionFaleConosco.setText("Fale conosco");
        optionFaleConosco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionFaleConoscoActionPerformed(evt);
            }
        });
        itemSobreNos.add(optionFaleConosco);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/barbeariacortes/view/img/icon-pessoa-corte.png"))); // NOI18N
        jMenuItem1.setText("Funcionários");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        itemSobreNos.add(jMenuItem1);

        jMenuBar.add(itemSobreNos);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSobreNosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSobreNosActionPerformed

    }//GEN-LAST:event_itemSobreNosActionPerformed

    private void optionFaleConoscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionFaleConoscoActionPerformed
        TelaContato telaContato = new TelaContato();
        telaContato.setVisible(true);
    }//GEN-LAST:event_optionFaleConoscoActionPerformed

    private void optionInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionInformacoesActionPerformed
        irTelaInformacoes();
    }//GEN-LAST:event_optionInformacoesActionPerformed

    private void optionServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionServicosActionPerformed
        irTelaServicos();
    }//GEN-LAST:event_optionServicosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaFuncionarios telaFuncionario = new TelaFuncionarios();
        telaFuncionario.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicosActionPerformed
        TelaServicos telaServicos = new TelaServicos();
        telaServicos.setVisible(true);
    }//GEN-LAST:event_btnServicosActionPerformed

    private void optionAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionAgendamentoActionPerformed
        irTelaAgendamento();
    }//GEN-LAST:event_optionAgendamentoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        voltarTelaLogin();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAgendar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendar1ActionPerformed
        irTelaAgendamento();
    }//GEN-LAST:event_btnAgendar1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAgendar1;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnServicos;
    private javax.swing.JMenu itemServico;
    private javax.swing.JMenu itemSobreNos;
    private javax.swing.JMenu itemUsuario;
    private javax.swing.JLabel jLabelBemVindo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem optionAgendamento;
    private javax.swing.JMenuItem optionFaleConosco;
    private javax.swing.JMenuItem optionInformacoes;
    private javax.swing.JMenuItem optionServicos;
    private javax.swing.JLabel txtNomeUsuario;
    // End of variables declaration//GEN-END:variables

    private void irTelaInformacoes() {
        ClienteDAO clienteDAO = new ClienteDAO();

        TelaInformacoes telaInformacoes = new TelaInformacoes();
        telaInformacoes.setVisible(true);
        telaInformacoes.getTxtNomeCompleto().setText(clienteDAO.getNomeCompleto(txtNomeUsuario.getText()));
        telaInformacoes.getTxtNomeUsuario().setText(txtNomeUsuario.getText());
        telaInformacoes.getTxtCPF().setText(clienteDAO.getCPF(txtNomeUsuario.getText()));
        telaInformacoes.getTxtEmail().setText(clienteDAO.getEmail(txtNomeUsuario.getText()));
        tl.dispose();
    }

    private void irTelaServicos() {
        TelaServicos telaServicos = new TelaServicos();
        telaServicos.setVisible(true);
    }

    private void irTelaAgendamento() {
        TelaAgendamento telaAgendamento = new TelaAgendamento();
        telaAgendamento.setVisible(true);

        AgendaDAO agendaDAO = new AgendaDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        telaAgendamento.getjLabelIdCliente().setText(clienteDAO.getIdCliente(txtNomeUsuario.getText()));
        agendaDAO.preencherTabelaAgendamentos(txtNomeUsuario.getText(), telaAgendamento);
    }

    private void voltarTelaLogin() {
        int result = JOptionPane.showConfirmDialog(null, "Deseja Sair para a tela inicial?");
        if (result == 0) {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
            tl.dispose();
        }
    }

    public JLabel getTxtNomeUsuario() {
        return txtNomeUsuario;
    }

    public void setTxtNomeUsuario(JLabel txtNomeUsuario) {
        this.txtNomeUsuario = txtNomeUsuario;
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
