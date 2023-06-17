package br.com.barbeariacortes.dao;

import br.com.barbeariacortes.dto.FuncionarioDTO;
import br.com.barbeariacortes.view.TelaCadastroAgendamento;
import br.com.barbeariacortes.view.TelaCadastroFunc;
import br.com.barbeariacortes.view.TelaFuncionarios;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioDAO {

    public boolean autentifacaoFuncioario(FuncionarioDTO funcionarioDTO) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_email_funcionario, c_senha_funcionario FROM tbl_funcionario ");
            sql.append("WHERE c_email_funcionario = ? AND c_senha_funcionario = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

            statement.setString(1, funcionarioDTO.getEmail());
            statement.setString(2, funcionarioDTO.getSenha());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
            return false;

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception);
            return false;
        }
    }

    public boolean eFuncionario(String nomeCompleto) {

        try {
            Connection conexaoDAO = new ConexaoDAO().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_nome_funcionario FROM tbl_funcionario ");
            sql.append("WHERE c_nome_funcionario = ? ");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, nomeCompleto);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public void preencherTabelaFuncionarios(TelaFuncionarios telaFuncionarios) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cf.c_nome_categoriafun, f.c_nome_funcionario ");
            sql.append("FROM tbl_funcionario f INNER JOIN tbl_categoria_fun cf ");
            sql.append(" ON cf.n_id_categoriafun = f.n_id_categoriafun");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel tabela = (DefaultTableModel) telaFuncionarios.getTblFuncionario().getModel();
            tabela.setNumRows(0);

            while (resultSet.next()) {
                tabela.addRow(new Object[]{
                    resultSet.getString("c_nome_categoriafun"),
                    resultSet.getString("c_nome_funcionario")
                });
            }
        } catch (Exception e) {
        }
    }

    public String getNomeCompleto(String email) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_nome_funcionario FROM tbl_funcionario ");
            sql.append("WHERE c_email_funcionario = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("c_nome_funcionario");
            }
            return "";

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception);
            return "";
        }
    }

    public String getCPF(String nomeCompleto) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_cpf_funcionario FROM tbl_funcionario ");
            sql.append("WHERE c_nome_funcionario = ? ");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, nomeCompleto);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("c_cpf_funcionario");
            }
            return "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }
    }

    public String getSalario(String nomeCompleto) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT f_salario_funcionario FROM tbl_funcionario ");
            sql.append("WHERE c_nome_funcionario  = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, nomeCompleto);

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');

            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return "R$ " + df.format(resultSet.getFloat("f_salario_funcionario")) + " reais";
            }
            return "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }
    }

    public String getEmail(String nomeCompleto) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_email_funcionario FROM tbl_funcionario ");
            sql.append("WHERE c_nome_funcionario = ? ");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, nomeCompleto);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("c_email_funcionario");
            }
            return "";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }
    }

    public int getIdFuncionario(String nomeCompleto) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT n_id_funcionario FROM tbl_funcionario ");
            sql.append("WHERE c_nome_funcionario = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, nomeCompleto);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("n_id_funcionario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return 0;
    }

    public void preencherComboBoxFuncionario(TelaCadastroAgendamento tela) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_nome_funcionario FROM tbl_funcionario");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            ResultSet resultSet = statement.executeQuery();

            DefaultComboBoxModel comboBox = (DefaultComboBoxModel) tela.getComboBoxFuncionario().getModel();
            while (resultSet.next()) {
                comboBox.addElement(resultSet.getString("c_nome_funcionario"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void preencherComboBoxCategoria(TelaCadastroFunc tela) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tbl_categoria_fun ");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            ResultSet resultSet = statement.executeQuery();

            DefaultComboBoxModel comboBox = (DefaultComboBoxModel) tela.getjComboBoxCategoria().getModel();
            while (resultSet.next()) {
                comboBox.addElement(resultSet.getString("c_nome_categoriafun"));
            }
        } catch (Exception e) {
        }

    }

    public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tbl_funcionario ");
            sql.append("(c_nome_funcionario,c_email_funcionario,c_cpf_funcionario,");
            sql.append("c_senha_funcionario,f_salario_funcionario,n_id_categoriafun)");
            sql.append("VALUES (?,?,?,?,?,?)");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

            statement.setString(1, funcionarioDTO.getNome());
            statement.setString(2, funcionarioDTO.getEmail());
            statement.setString(3, funcionarioDTO.getCpf());
            statement.setString(4, funcionarioDTO.getSenha());
            statement.setFloat(5, funcionarioDTO.getSalario());
            statement.setInt(6, funcionarioDTO.getCategoria());

            statement.execute();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int getCategoriaFuncionario(String categoria) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT n_id_categoriafun FROM tbl_categoria_fun ");
            sql.append("WHERE c_nome_categoriafun = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, categoria);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("n_id_categoriafun");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return 0;
    }
}
