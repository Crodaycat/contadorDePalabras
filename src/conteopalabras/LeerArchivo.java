/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conteopalabras;

import java.io.*;

public class LeerArchivo {

       FileInputStream entrada;
       
       public String AbrirTexto(File archivo){
           String contenido = "";
           int codigo;
           
           try {
               entrada = new FileInputStream(archivo);
               
               while((codigo = entrada.read()) != -1){
                   char caracter = (char)codigo;
                   contenido += caracter;
               }              
           } catch (Exception e){
               
           }
           return contenido;
       }
    
}