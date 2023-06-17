package br.com.barbeariacortes.dao;

import br.com.barbeariacortes.dto.ClienteDTO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ClienteDAO {

    public boolean autentifacaoCliente(ClienteDTO clienteDTO) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_email_cliente, c_senha_cliente FROM tbl_cliente ");
            sql.append("WHERE c_email_cliente =  ? AND c_senha_cliente = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

            statement.setString(1, clienteDTO.getEmail());
            statement.setString(2, clienteDTO.getSenha());

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

    public boolean cadastrarCliente(ClienteDTO clienteDTO) {
        if (eClienteExistente(clienteDTO)) {
            JOptionPane.showMessageDialog(null, "Já existe um cadastro com esse CPF, por favor digite novamente");
            return false;
        } else {
            Connection conexaoDAO = new ConexaoDAO().getConnection();

            try {
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO tbl_cliente ");
                sql.append("(c_nome_cliente, c_email_cliente,");
                sql.append("c_cpf_cliente, c_usuario_cliente, c_senha_cliente) ");
                sql.append("VALUES (?,?,?,?,?)");

                PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

                statement.setString(1, clienteDTO.getNome());
                statement.setString(2, clienteDTO.getEmail());
                statement.setString(3, clienteDTO.getCpf());
                statement.setString(4, clienteDTO.getNomeUsuario());
                statement.setString(5, clienteDTO.getSenha());

                statement.execute();

                statement.close();
                conexaoDAO.close();

                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

                return true;
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Erro: " + exception);
                return false;
            }

        }

    }

    public boolean excluirClienteExistente(ClienteDTO clienteDTO) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM tbl_cliente ");
            sql.append("WHERE c_email_cliente = ? ");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

            statement.setString(1, clienteDTO.getEmail());

            statement.execute();

            JOptionPane.showMessageDialog(null, "Excluído");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não é possível excluir o usuário pois há um agendamento, exclua o agendamento para remover o usuário");
        }
        return false;
    }

    public boolean autentificarEmail(String email) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT n_id_cliente FROM tbl_cliente ");
            sql.append("WHERE c_email_cliente = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

            statement.setString(1, email);

            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "Solicitação de redefinição foi aceita, foi enviado uma mensagem para o seu e-mail");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "E-mail não encontrado, por favor digite novamente");
                return false;
            }

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception);
            return false;
        }
    }

    public boolean eClienteExistente(ClienteDTO clienteDTO) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_cpf_cliente FROM tbl_cliente ");
            sql.append("WHERE c_cpf_cliente = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

            statement.setString(1, clienteDTO.getCpf());

            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Erro: " + exception);
            return false;
        }
    }

    // Getter Informações
    public String getIdCliente(String nomeUsuario) {
        try {
            Connection conexaoDAO = new ConexaoDAO().getInstance().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT n_id_cliente FROM tbl_cliente ");
            sql.append("WHERE c_usuario_cliente = ? ");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, nomeUsuario);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("n_id_cliente");
            }
            return "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }
    }

    public String getNomeUsuario(String email) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_usuario_cliente FROM tbl_cliente ");
            sql.append("WHERE c_email_cliente = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());

            statement.setString(1, email);

            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                return resultado.getString("c_usuario_cliente");
            }
            statement.close();
            conexaoDAO.close();
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public String getCPF(String nomeUsuario) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_cpf_cliente FROM tbl_cliente ");
            sql.append("WHERE c_usuario_cliente = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, nomeUsuario);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("c_cpf_cliente");
            }
            statement.close();
            conexaoDAO.close();
            return "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }
    }

    public String getNomeCompleto(String nomeUsuario) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_nome_cliente FROM tbl_cliente ");
            sql.append("WHERE c_usuario_cliente = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, nomeUsuario);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("c_nome_cliente");
            }
            return "";

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception);
            return "";
        }
    }

    public String getEmail(String nomeUsuario) {
        Connection conexaoDAO = new ConexaoDAO().getConnection();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c_email_cliente FROM tbl_cliente ");
            sql.append("WHERE c_usuario_cliente = ?");

            PreparedStatement statement = conexaoDAO.prepareStatement(sql.toString());
            statement.setString(1, nomeUsuario);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("c_email_cliente");
            }

            return "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }
    }

}
