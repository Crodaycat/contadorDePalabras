/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conteopalabras;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ProcesarTexto {
    private String texto;
    private int n;
    private String frecuencia[]= new String[1000];
    int conteo [] = new int [1000];
    
    ProcesarTexto (String a) {
        texto = a + ".";
    }
    
    public void AdaptarTexto () {
        texto = texto.replaceAll("á", "a");
        texto = texto.replaceAll("é", "e");
        texto = texto.replaceAll("í", "i");
        texto = texto.replaceAll("ó", "o");
        texto = texto.replaceAll("ú", "u");
    }
    
    public void FrecuenciaPalabras (JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        n = texto.length() - 1;
        String car, palabra, abecedario = "abcdefghijklmnñopqrstuvwxyz";
        int i = 0, m = 0, j;
        boolean k;
        
        for (int z = 0; z < 1000; z++) {
            conteo[z] = 0;
        }
        
        while (i < n) {
            car = (texto.substring(i, i+1)).toLowerCase();
            k = abecedario.contains(car);
            while (i < n && k == false) {
                i += 1;
                car = (texto.substring(i, i+1)).toLowerCase();
                k = abecedario.contains(car);
            }
            j = i;
            while (i < n && k != false) {
                i += 1;
                car = (texto.substring(i, i+1)).toLowerCase();
                k = abecedario.contains(car);
            }
            
            palabra = (texto.substring(j, i)).toLowerCase();
            
           if ((i+1) == (n) && abecedario.contains(texto.substring(i,i+1).toLowerCase()))
           {
               palabra += texto.substring(i,i+1);
               i++;
           }
            
            frecuencia[m] = palabra;
            
            
            j = 0;
            while (!(frecuencia[j].toLowerCase().equals(palabra.toLowerCase()))) {
                j += 1;
            }
            
            if (j == m){
                conteo[m] = 1;
                m += 1;
            }else {
                conteo[j] += 1;
            }
        }
        m -= 1;
        modelo.setRowCount(0);
        for (int z = 0; z <= m; z++){
            if (frecuencia[z] != "")
                modelo.insertRow(modelo.getRowCount() ,new Object[]{this.frecuencia[z], String.valueOf(this.conteo[z])});
        }
        
        
    }
}
