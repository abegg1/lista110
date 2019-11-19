/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftec.agenda.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADM
 */
public class Conexao {

    private static String usuario = "root";
    private static String senha = "";
    private static String url = "jdbc:mysql://localhost:3306/agenda";

    public static Connection criaConexao() throws ClassNotFoundException, SQLException {

        //Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.jdbc.Driver");

        //Cria a conexão com o banco de dados
        Connection connection
                = DriverManager.getConnection(url,
                        usuario, senha);

        return connection;

    }

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        Connection con = criaConexao();

        //Testa se a conexão é nula
        if (con != null) {
            System.out.println("Conexão obtida com sucesso!" + con);
            con.close();
        }

    }

}
