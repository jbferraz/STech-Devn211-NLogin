/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NLogin.model;

/**
 *
 * @author jbferraz
 */
public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String usuario;
    private String senha;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nomeUsuario, String usuario, String senha) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", usuario=" + usuario + ", senha=" + senha + '}';
    }
    
    
}
