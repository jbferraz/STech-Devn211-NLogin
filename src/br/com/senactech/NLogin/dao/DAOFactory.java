/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NLogin.dao;

/**
 *
 * @author jbferraz
 */
public class DAOFactory {
    private static UsuarioDAO uDAO = new UsuarioDAO();
    
    public static UsuarioDAO getUsuarioDAO(){
        return uDAO;
    }
}
