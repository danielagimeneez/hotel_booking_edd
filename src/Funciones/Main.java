/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;
import HashTable.Hashtable;
import Interfaces.VentanaPrincipal;
/**
 *
 * @author Asdrubal Rivas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaPrincipal MainMenu = new VentanaPrincipal();
        MainMenu.setLocationRelativeTo(null);
        MainMenu.setSize(600, 400);
        MainMenu.setResizable(false);
        MainMenu.setTitle("Hotel");
        MainMenu.setVisible(true);
        Hashtable hashtable = new Hashtable();

        // Agregar elementos a la Hashtable
        

        // Mostrar los elementos en pantalla
        //hashtable.mostrarHashtable();
    }
        
        
    }
    
