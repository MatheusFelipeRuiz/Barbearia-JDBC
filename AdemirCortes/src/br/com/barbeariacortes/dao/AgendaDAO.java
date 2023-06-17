package br.com.barbeariacortes.dao;

import br.com.barbeariacortes.view.TelaAgendamento;
import br.com.barbeariacortes.view.TelaAgendamentoFunc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AgendaDAO {

    public void preencherTabelaAgendamentos(String nomeUsuario, TelaAgendamento telaAgendamento) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT a.d_data_agendamento, a.d_hora_agendamento, ");
            sql.append("f.c_nome_funcionario, s.c_nome_servico,a.f_total_agendamento ");
            sql.append("FROM tbl_agendamento a INNER JOIN tbl_funcionario f ON ");
            sql.append("a.n_id_funcionario = f.n_id_funcionario ");
            sql.append("INNER JOIN tbl_servico s ON s.n_id_servico = a.n_id_servico ");
            sql.append("INNER JOIN tbl_cliente c ON a.n_id_cliente = c.n_id_cliente ");
            sql.append("WHERE c.c_usuario_cliente = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

            statement.setString(1, nomeUsuario);

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');

            DefaultTableModel tabela = (DefaultTableModel) telaAgendamento.getTblAgendamentos().getModel();
            tabela.setRowCount(0);

            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            String preco = "";
            String[] hora;
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hora = resultSet.getString("a.d_hora_agendamento").split(":");
                String horaF = hora[0] + ":" + hora[1];
                tabela.addRow(new Object[]{
                    sdf.format(resultSet.getDate("a.d_data_agendamento")),
                    horaF,
                    resultSet.getString("f.c_nome_funcionario"),
                    resultSet.getString("s.c_nome_servico"),
                    preco = "R$ " + df.format(resultSet.getFloat("a.f_total_agendamento")) + " reais"
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    

    public void preencherTabelaAgendamentos(int idCliente, TelaAgendamento telaAgendamento) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT a.d_data_agendamento, a.d_hora_agendamento, ");
            sql.append("f.c_nome_funcionario, s.c_nome_servico,a.f_total_agendamento ");
            sql.append("FROM tbl_agendamento a INNER JOIN tbl_funcionario f ON ");
            sql.append("a.n_id_funcionario = f.n_id_funcionario ");
            sql.append("INNER JOIN tbl_servico s ON s.n_id_servico = a.n_id_servico ");
            sql.append("INNER JOIN tbl_cliente c ON a.n_id_cliente = c.n_id_cliente ");
            sql.append("WHERE c.n_id_cliente = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

            statement.setInt(1, idCliente);

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');

            DefaultTableModel tabela = (DefaultTableModel) telaAgendamento.getTblAgendamentos().getModel();
            tabela.setRowCount(0);

            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            String preco = "";
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tabela.addRow(new Object[]{
                    sdf.format(resultSet.getDate("a.d_data_agendamento")),
                    resultSet.getString("a.d_hora_agendamento"),
                    resultSet.getString("f.c_nome_funcionario"),
                    resultSet.getString("s.c_nome_servico"),
                    preco = "R$ " + df.format(resultSet.getFloat("a.f_total_agendamento")) + " reais"
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

        public void preencherTabelaAgendamentos(int idFuncionario, TelaAgendamentoFunc telaAgendamentoF) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT a.d_data_agendamento, a.d_hora_agendamento, ");
            sql.append("c.c_nome_cliente, s.c_nome_servico,a.f_total_agendamento ");
            sql.append("FROM tbl_agendamento a INNER JOIN tbl_funcionario f ON ");
            sql.append("a.n_id_funcionario = f.n_id_funcionario ");
            sql.append("INNER JOIN tbl_servico s ON s.n_id_servico = a.n_id_servico ");
            sql.append("INNER JOIN tbl_cliente c ON a.n_id_cliente = c.n_id_cliente ");
            sql.append("WHERE f.n_id_funcionario = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

            statement.setInt(1, idFuncionario);

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');

            DefaultTableModel tabela = (DefaultTableModel) telaAgendamentoF.getTblAgendamentos().getModel();
            tabela.setRowCount(0);

            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            String preco = "";
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tabela.addRow(new Object[]{
                    sdf.format(resultSet.getDate("a.d_data_agendamento")),
                    resultSet.getString("a.d_hora_agendamento"),
                    resultSet.getString("c.c_nome_cliente"),
                    resultSet.getString("s.c_nome_servico"),
                    preco = "R$ " + df.format(resultSet.getFloat("a.f_total_agendamento")) + " reais"
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean validarAgendamento(String data, String hora, int funcionario, int cliente, int servico, float preco) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tbl_agendamento ");
            sql.append(" (`d_data_agendamento`, `d_hora_agendamento`, ");
            sql.append("`n_id_funcionario`, `n_id_cliente`, `n_id_servico`, `f_total_agendamento`) ");
            sql.append("VALUES (?, ?, ? , ?, ?, ?)");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, data);
            statement.setString(2, hora);
            statement.setInt(3, funcionario);
            statement.setInt(4, cliente);
            statement.setInt(5, servico);
            statement.setFloat(6, preco);

            statement.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean validarAgendamento(String data, String hora, int idCliente) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT n_id_agendamento FROM tbl_agendamento ");
            sql.append("WHERE d_data_agendamento = ? AND ");
            sql.append("d_hora_agendamento = ? AND ");
            sql.append("n_id_cliente = ? ");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, data);
            statement.setString(2, hora);
            statement.setInt(3, idCliente);
            
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

    public boolean excluirAgendamento(String data, String hora, int idCliente) {
        if (!validarAgendamento(data, hora, idCliente)) {
            return false;
        } else {
            try {
                Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
                StringBuilder sql = new StringBuilder();
                sql.append("DELETE FROM tbl_agendamento ");
                sql.append("WHERE d_data_agendamento = ? AND ");
                sql.append("d_hora_agendamento = ? AND ");
                sql.append("n_id_cliente = ? ");

                PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
                statement.setString(1, data);
                statement.setString(2, hora);
                statement.setInt(3, idCliente);

                statement.execute();
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            }
        }
    }
}
