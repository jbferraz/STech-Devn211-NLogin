/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NLogin.dao;

import br.com.senactech.NLogin.conexao.Conexao;
import br.com.senactech.NLogin.model.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static nlogin.NLogin.geraSenha;

/**
 *
 * @author jbferraz
 */
public class UsuarioDAO {

    public void cadUsuario(Usuario uVO){        
        try(Connection con = Conexao.getConexao();
                Statement stat = con.createStatement();) {
            String sql;
            sql = "insert into usuario values(null,"
                    + "'" + uVO.getNomeUsuario() + "',"
                    + "'" + uVO.getUsuario() + "',"
                    + "'" + uVO.getSenha() + "')";
            stat.execute(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir.\n" + e.getMessage(),
                    "Erro",JOptionPane.ERROR_MESSAGE);
        } 
    }

    public Usuario getByUsuario(String user) throws SQLException {
        //Abre conexão com BD
        Connection con = Conexao.getConexao();
        //Cria área de execução de script SQL
        Statement stat = con.createStatement();
        Usuario u = new Usuario();
        try {
            String sql;
            sql = "select * from usuario where usuario='" + user + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNomeUsuario(rs.getString("nomeUsuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            throw new SQLException("Usuario não encontrado.\n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return u;
    }

    public ArrayList<Usuario> listaUsuarios() throws SQLException {
        //Abre conexão com BD
        Connection con = Conexao.getConexao();
        //Cria área de execução de script SQL
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "select idUsuario, nomeUsuario, usuario from usuario";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNomeUsuario(rs.getString("nomeUsuario"));
                u.setUsuario(rs.getString("usuario"));
                usuarios.add(u);
            }
            return usuarios;
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar usuários!\n"
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public void atualizarUsuario(Usuario uVO) throws SQLException,
            NoSuchAlgorithmException, UnsupportedEncodingException {
        //Abre conexão com BD
        Connection con = Conexao.getConexao();
        //Cria área de execução de script SQL
        //Statement stat = con.createStatement();
        String sql;
        sql = "update usuario set nomeUsuario = ?, senha = ? where idUsuario = ?";
        PreparedStatement pStat = con.prepareStatement(sql);
        try {
            pStat.setString(1, uVO.getNomeUsuario());
            pStat.setString(2, geraSenha(uVO.getSenha()));
            pStat.setInt(3, uVO.getIdUsuario());
            pStat.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar.\n" + e.getMessage());
        } finally {
            pStat.close();
            con.close();
        }
    }

    public void deletarUsuario(int id) throws SQLException {
        //Abre conexão com BD
        Connection con = Conexao.getConexao();
        //Cria área de execução de script SQL
        String sql;
        sql = "delete from usuario where idUsuario = ?";
        try (PreparedStatement pStat = con.prepareStatement(sql)) {
            pStat.setInt(1, id);
            pStat.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar.\n" + e.getMessage());
        } finally {
            con.close();
        }
    }
}
