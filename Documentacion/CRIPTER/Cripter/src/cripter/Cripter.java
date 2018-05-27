/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cripter;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ms_diez
 */
public class Cripter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadenaDeTexto = "user";
        String cadenaEncriptada = "";
        try {
            System.out.println("Cadena original > "+cadenaDeTexto);
            cadenaEncriptada = encriptar(cadenaDeTexto);
            System.out.println("Cadena encriptada > "+cadenaEncriptada);
            String cadenaDesencriptada = desencriptar(cadenaEncriptada);
            System.out.println("Cadena desencriptada > "+cadenaDesencriptada);
        } catch (UnsupportedEncodingException uee) {
            System.out.println("Ups!! > "+uee);
        }
    }
    
    private static String encriptar(String s) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
    
    private static String desencriptar(String s) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }

   
}
