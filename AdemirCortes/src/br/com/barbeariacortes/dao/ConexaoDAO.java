package br.com.barbeariacortes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ConexaoDAO {

    private static ConexaoDAO conexaoDAO;
    
    public static ConexaoDAO getInstance(){
        if(conexaoDAO == null){
            conexaoDAO = new ConexaoDAO();
        }
        return conexaoDAO;
    }
    
    public Connection getConnection() {
        Connection conexao = null;
        String driver = "jdbc";
        String bancoDados = "mysql";
        String ipPorta = "127.0.0.1:3306";
        String baseDados = "db_barbearia";
        String user = "root";
        String password = "12345";
        String urlPrincipal = "";
        try {
            String url = driver + ":" + bancoDados + "://" + ipPorta + "/" + baseDados;
            url += "?user=" + user + "&password=" + password + "";
            urlPrincipal = url;
            conexao = DriverManager.getConnection(url);
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception);
            System.out.println(urlPrincipal);
        }
        return conexao;
    }

}
