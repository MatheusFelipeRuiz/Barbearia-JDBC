package br.com.barbeariacortes.dao;

import br.com.barbeariacortes.dto.ServicoDTO;
import br.com.barbeariacortes.view.TelaCadastroAgendamento;
import br.com.barbeariacortes.view.TelaServicos;
import br.com.barbeariacortes.view.TelaServicosF;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ServicosDAO {

    public void preencherTabela(TelaServicos telaServicos) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_nome_servico, c_desc_servico, f_preco_servico ");
            sql.append("FROM tbl_servico");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel tabela = (DefaultTableModel) telaServicos.getTblServico().getModel();
            tabela.setNumRows(0);

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');

            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

            while (resultSet.next()) {
                String preco = "R$ " + df.format(resultSet.getFloat("f_preco_servico")) + " reais";
                tabela.addRow(new Object[]{
                    resultSet.getString("c_nome_servico"),
                    resultSet.getString("c_desc_servico"),
                    preco
                });
            }

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Erro: " + exception);
        }
    }

    public void preencherTabela(TelaServicosF telaServicos) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_nome_servico, c_desc_servico, f_preco_servico ");
            sql.append("FROM tbl_servico");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel tabela = (DefaultTableModel) telaServicos.getTblServico().getModel();
            tabela.setNumRows(0);

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');

            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

            while (resultSet.next()) {
                String preco = "R$ " + df.format(resultSet.getFloat("f_preco_servico")) + " reais";
                tabela.addRow(new Object[]{
                    resultSet.getString("c_nome_servico"),
                    resultSet.getString("c_desc_servico"),
                    preco
                });
            }

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Erro: " + exception);
        }
    }

    public void preencherComboBoxServico(TelaCadastroAgendamento tela) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_nome_servico FROM tbl_servico");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            ResultSet resultSet = statement.executeQuery();
            DefaultComboBoxModel comboBox = (DefaultComboBoxModel) tela.getComboBoxServico().getModel();
            while (resultSet.next()) {
                comboBox.addElement(resultSet.getString("c_nome_servico"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void preencherPrecoServico(TelaCadastroAgendamento tela) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT f_preco_servico FROM tbl_servico ");
            sql.append("WHERE c_nome_servico = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, tela.getComboBoxServico().getModel().getSelectedItem().toString());

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');

            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
            String preco = "";

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                preco = "R$ " + df.format(resultSet.getFloat("f_preco_servico")) + " reais";
                tela.getTxtPreco().setText(preco);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int getIdServico(String nome) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT n_id_servico FROM tbl_servico ");
            sql.append("WHERE c_nome_servico = ? ");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("n_id_servico");
            }
            return 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public float getPrecoServico(int idServico) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT f_preco_servico FROM tbl_servico ");
            sql.append("WHERE n_id_servico = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setInt(1, idServico);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getFloat("f_preco_servico");
            }
            return 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }
    
    public boolean excluirServico(ServicoDTO servicoDTO){
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM tbl_servico ");
            sql.append("WHERE c_nome_servico = ? AND ");
            sql.append("c_desc_servico = ? ");
            
            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, servicoDTO.getNome());
            statement.setString(2, servicoDTO.getDescricao());
            
            statement.execute();
            statement.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
    public boolean cadastrarServico(ServicoDTO servicoDTO){
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tbl_servico ");
            sql.append("(c_nome_servico, c_desc_servico, f_preco_servico) ");
            sql.append("VALUES (?,?,?)");
            
            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, servicoDTO.getNome());
            statement.setString(2, servicoDTO.getDescricao());
            statement.setFloat(3, servicoDTO.getPreco());
            
            statement.execute();
            statement.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
}
