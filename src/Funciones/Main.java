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
        hashtable.agregar("Kay McPherson", 2);
        hashtable.agregar("Naranja", 5);
        hashtable.agregar(28101757, "Hola");
        hashtable.eliminarElemento("Naranja");
        hashtable.buscarValor("Kay McPherson");
        hashtable.BusquedsaDeReservacion(28101757);

        // Mostrar los elementos en pantalla
        //hashtable.mostrarHashtable();
    }
        
        
    }
    
