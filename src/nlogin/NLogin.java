/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nlogin;

import br.com.senactech.NLogin.model.Usuario;
import br.com.senactech.NLogin.services.ServicosFactory;
import br.com.senactech.NLogin.services.UsuarioServicos;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author jbferraz
 */
public class NLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, 
            NoSuchAlgorithmException, UnsupportedEncodingException {
        // TODO code application logic here
        //User: jbferraz | pass: admin
        //User: admin | pass: admin123456
        Scanner ler = new Scanner(System.in);
        Usuario u;
        UsuarioServicos uServicos = ServicosFactory.getUsuarioServicos();
        
        System.out.println(".: Login :.");
        System.out.print("Informe o usuario: ");
        u = uServicos.getByUsuario(ler.next());
        System.out.print("Informe a senha: ");
        String senha = geraSenha(ler.next());
        if (senha.equals(u.getSenha())) {
            //setVisible o jFrame principal
            System.out.println("\nUsuario logado com sucesso.\n");
        }else{
            //Desvolve uma msg de erro e volta pro login
            System.out.println("\nUsuario ou senha incorretos.\n");
        }
    }
    
    /**
     * Este método gera senha encript MD5
     * @param senha
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException 
     */
    public static String geraSenha(String senha) throws NoSuchAlgorithmException,
            UnsupportedEncodingException{
        MessageDigest mdMD5 = MessageDigest.getInstance("MD5");
        byte mdByteMD5[] = mdMD5.digest(senha.getBytes("UTF-8"));
        StringBuilder hexMDMD5 = new StringBuilder();
        for (byte b : mdByteMD5) {
            hexMDMD5.append(String.format("%02X", 0xFF & b));
        }
        String senhaMD5HashHex = hexMDMD5.toString();
        return senhaMD5HashHex;
    }
}
