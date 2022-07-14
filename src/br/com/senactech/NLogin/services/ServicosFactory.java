/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NLogin.services;

/**
 *
 * @author jbferraz
 */
public class ServicosFactory {
    private static UsuarioServicos uServicos = new UsuarioServicos();
    
    public static UsuarioServicos getUsuarioServicos(){
        return uServicos;
    }
}
