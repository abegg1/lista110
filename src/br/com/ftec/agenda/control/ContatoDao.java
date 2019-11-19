/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftec.agenda.control;

import br.com.ftec.agenda.model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADM
 */
public class ContatoDao {
    
    public void salvarContato(Contato contato) 
            throws ClassNotFoundException, SQLException{
        
        
        String sql = "insert into agenda (nome, telefone, email)"
                 + "values (?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;       
        conn = Conexao.criaConexao();
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, contato.getNome());
        pstm.setString(2, contato.getTelefone());
        pstm.setString(3, contato.getEmail());
        pstm.execute();     
     
    }
    
    
    public ArrayList<Contato> listaContatos() throws ClassNotFoundException, SQLException{
        String sql = "Select * from agenda order by nome";
        
        Connection conn = null;
        PreparedStatement pstm = null; 
        ResultSet rset = null;
        
        conn = Conexao.criaConexao();
        pstm = conn.prepareStatement(sql);
        rset = pstm.executeQuery();
        
        ArrayList<Contato> listaContatos = new ArrayList<>();
        
        while(rset.next()){
            Contato contato = new Contato();
            contato.setId(rset.getInt("id"));
            contato.setNome(rset.getString("nome"));
            contato.setEmail(rset.getString("email"));
            contato.setTelefone(rset.getString("telefone"));
            listaContatos.add(contato);
            
        }
        return listaContatos;
        
                
    }
    
    public void excluirContato(int id) throws ClassNotFoundException, SQLException{
        String sql = "delete from agenda where id = "+id;
        Connection conn =null;
        PreparedStatement pstm = null;
        conn = Conexao.criaConexao();
        pstm = conn.prepareStatement(sql);
        pstm.executeUpdate();
        
    }

    public Contato listaContatosPorId(int valor) throws ClassNotFoundException, SQLException {
 
         String sql =" Select * from agenda where id ="+valor;        
        Connection conn = null;
        PreparedStatement pstm = null; 
        ResultSet rset = null;
        
        conn = Conexao.criaConexao();
        pstm = conn.prepareStatement(sql);
        rset = pstm.executeQuery();       
       
        Contato contato = new Contato();
        while(rset.next()){
            
            contato.setId(rset.getInt("id"));
            contato.setNome(rset.getString("nome"));
            contato.setEmail(rset.getString("email"));
            contato.setTelefone(rset.getString("telefone"));
          
            
        }
        return contato;    

    }
    
}
