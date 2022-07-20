/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NLogin.services;

import br.com.senactech.NLogin.dao.DAOFactory;
import br.com.senactech.NLogin.dao.UsuarioDAO;
import br.com.senactech.NLogin.model.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jbferraz
 */
public class UsuarioServicos {

    private final UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();

    public void cadUsuario(Usuario uVO) {
        uDAO.cadUsuario(uVO);
    }

    public Usuario getByUsuario(String user) throws SQLException {
        return uDAO.getByUsuario(user);
    }

    public ArrayList<Usuario> getUsuarios() throws SQLException {
        return uDAO.listaUsuarios();
    }

    public void atualizarUsuario(Usuario uVO) throws SQLException,
            NoSuchAlgorithmException, UnsupportedEncodingException {
        uDAO.atualizarUsuario(uVO);
    }

    public void deletarUsuario(int id) throws SQLException {
        uDAO.deletarUsuario(id);
    }
}
