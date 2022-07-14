/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NLogin.services;

import br.com.senactech.NLogin.dao.DAOFactory;
import br.com.senactech.NLogin.dao.UsuarioDAO;
import br.com.senactech.NLogin.model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author jbferraz
 */
public class UsuarioServicos {

    public void cadUsuario(Usuario uVO) throws SQLException {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.cadUsuario(uVO);
    }
    
    public Usuario getByUsuario(String user) throws SQLException{
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.getByUsuario(user);
    }
}
