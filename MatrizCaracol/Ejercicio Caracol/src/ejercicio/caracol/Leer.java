/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.caracol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Braya
 */
public class Leer {
    String dir;
    File file = new File("../Ejercicio Caracol/src/Resources/caracol.txt");
    int a=0,b=0;
    String[][] leer;
    Leer()
    {
        
    }
    
    public void Caracolleer()
    {
        
        try {
            Scanner sc = new Scanner(file);
            dir = sc.nextLine();
            while (sc.hasNextLine()) {                
                
                dir=dir + " " + sc.nextLine();
                a++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
            String part[]=dir.split(" ");
            leer = new String[a+1][a+1];
            
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j <= a; j++) {
                    leer[i][j] = part[b];
                    b++;
                }
        }
            MatrizCaracol ca = new MatrizCaracol(a+1,leer);
            ca.CargarMatriz();
            for(int i=0;i<=a;i++){    
            ca.Lineabien();
            ca.ColumnaAbajo();
            ca.InversaFila();
            ca.ArribaColumna();
            i++;
            
        }
        JOptionPane.showMessageDialog(null,ca.getarray()); 
            
        
    }
}
