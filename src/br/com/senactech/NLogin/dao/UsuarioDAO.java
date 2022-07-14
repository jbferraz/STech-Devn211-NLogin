/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NLogin.dao;

import br.com.senactech.NLogin.conexao.Conexao;
import br.com.senactech.NLogin.model.Usuario;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author jbferraz
 */
public class UsuarioDAO {

    public void cadUsuario(Usuario uVO) throws SQLException {
        //Abre conexão com BD
        Connection con = Conexao.getConexao();
        //Cria área de execução de script SQL
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "insert into usuario values(null,"
                    + "'" + uVO.getNomeUsuario() + "',"
                    + "'" + uVO.getUsuario() + "',"
                    + "'" + uVO.getSenha() + "')";
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir.\n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
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
        }finally{
            con.close();
            stat.close();
        }
        return u;
    }
}
