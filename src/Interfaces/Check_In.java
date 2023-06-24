/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import Funciones.Robustez;
import static Funciones.Excel.verificarNumeroEnColumnaPagina3;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import HashTable.Hashtable;
import java.awt.List;
import java.awt.TextField;

/**
 *
 * @author Asdrubal Rivas
 */
public class Check_In extends javax.swing.JFrame {

    /**
     * Creates new form Check_In
     */
    public Check_In() {
        initComponents();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Apellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Cedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Correo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Phone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        Habitacion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        H_Salida = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        H_Llegada = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingresa tu nombre");

        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingresa tu apellido");

        jLabel3.setText("Ingresa tu cedula");

        jLabel4.setText("Ingresa tu correo");

        jLabel5.setText("Ingresa tu telefono");

        jLabel6.setText("Ingresa tu genero");

        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre ", "Mujer", "Otro" }));

        jLabel9.setText("Numero de habitacion");

        Habitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HabitacionActionPerformed(evt);
            }
        });

        jLabel10.setText("Hora de salida");

        jLabel11.setText("Hora de llegada");

        jButton2.setText("Registrarse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(H_Llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(H_Salida, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(Habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(H_Llegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(H_Salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        VentanaPrincipal MainMenu = new VentanaPrincipal();
        MainMenu.setLocationRelativeTo(null);
        MainMenu.setSize(600, 400);
        MainMenu.setResizable(false);
        MainMenu.setTitle("Hotel");
        MainMenu.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    public void verificarCampos(JTextField[] textFields) {
    boolean todosLlenos = true;

    for (JTextField textField : textFields) {
        if (textField.getText().isEmpty()) {
            todosLlenos = false;
            JOptionPane.showMessageDialog(rootPane, "Falto algun espacio por rellenar");
            break;
        }
    }

    
}
    public boolean EsLetra(JTextField textField) {
    String texto = textField.getText();
    try {
        Integer.parseInt(texto); // Intenta convertir el texto a un número entero
        JOptionPane.showMessageDialog(rootPane, "El apartado Nombre y apellido solo puede contener letras");
        return false; // Si no se lanza una excepción, el texto es un número entero
    } catch (NumberFormatException e) {
         
        return true;
    }
}
    
    public boolean EsNumero(JTextField textField) {
    String texto = textField.getText();
    try {
        Integer.parseInt(texto);
        // Intenta convertir el texto a un número entero
        

        return true; // Si no se lanza una excepción, el texto es un número entero
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(rootPane, "El apartado Cedula,Numero de Habitacion, telefono y Horas de llegada y salida, solo puede contener numeros");
        return false;
    }
}

    public boolean verificarFormatoFecha(JTextField textField) {
    String texto = textField.getText();
    String formatoFecha = "\\d{2}/\\d{2}/\\d{4}";

    if (texto.matches(formatoFecha)) {
        return true;
    } else {
        JOptionPane.showMessageDialog(rootPane, "Fecha Invalida");
        return false;
    }
}


    public boolean verificarCorreo(JTextField textField) {
    String texto = textField.getText();
    int contadorArroba = 0;
    int contadorPunto = 0;

    for (char c : texto.toCharArray()) {
        if (c == '@') {
            contadorArroba++;
        } else if (c == '.') {
            contadorPunto++;
        }
    }

    if (contadorArroba == 1 && contadorPunto == 1) {
        return true;
    } else {
        
        JOptionPane.showMessageDialog(rootPane, "Correo Invalido");
        return false;
    }
    }

    public boolean VerificarArreglo(boolean[] arreglo) {
    for (boolean elemento : arreglo) {
        if (!elemento) {
            JOptionPane.showMessageDialog(rootPane, "Ocurrio un error inesperado");
            return false;
        }
    }
    JOptionPane.showMessageDialog(rootPane, "Te registraste fino");
    return true;
}
    
    public boolean verificarResultados(JTextField Nombre, JTextField Apellido, JTextField Correo, JTextField Cedula, JTextField H_Llegada, JTextField H_Salida, JTextField Phone) {
        boolean resultado1 = EsLetra(Nombre);
        boolean resultado2 = EsLetra(Apellido);
        boolean resultado3 = EsNumero(Cedula);
        boolean resultado4 = verificarCorreo(Correo);
        boolean resultado5 = verificarFormatoFecha(H_Llegada);
        boolean resultado6 = verificarFormatoFecha(H_Salida);
        boolean resultado7 = EsNumero(Phone);
        System.err.println(resultado1);
        System.err.println(resultado2);
        System.err.println(resultado3);
        System.err.println(resultado4);
        System.err.println(resultado5);
        System.err.println(resultado6);
        System.err.println(resultado7);

        if (resultado1 && resultado2 && resultado3 && resultado4 && resultado5 && resultado6 && resultado7){
            JOptionPane.showMessageDialog(rootPane, "Te registraste exitosamente !");
            return true;
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ocurrio un error en tu registro");
            return false;
        }
    }

    
    public void HabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HabitacionActionPerformed
    
    public void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JTextField[] campos = {Nombre,Cedula,Phone,Apellido,Correo,Habitacion,H_Llegada,H_Salida};
        verificarCampos(campos);
//        EsLetra(Nombre);
//        EsLetra(Apellido);
//        EsNumero(Cedula);
//        verificarCorreo(Correo);
        //La fecha tiene que ser asi: 02/10/2020
//        verificarFormatoFecha(H_Llegada);
//        verificarFormatoFecha(H_Salida);
        verificarResultados(Nombre, Apellido, Correo, Cedula, H_Llegada, H_Salida, Phone);
        //System.err.println(Gender.getSelectedItem());
        Hashtable hashtable = new Hashtable();
        hashtable.imprimirKeys();
        //Falta lo de ver si la Hbitacion esta llena o Vacia y agregarlo a la hashtable
       

    }//GEN-LAST:event_jButton2ActionPerformed

    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Check_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Check_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Check_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Check_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Check_In().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Apellido;
    public javax.swing.JTextField Cedula;
    public javax.swing.JTextField Correo;
    public javax.swing.JComboBox<String> Gender;
    public javax.swing.JTextField H_Llegada;
    public javax.swing.JTextField H_Salida;
    public javax.swing.JTextField Habitacion;
    public javax.swing.JTextField Nombre;
    public javax.swing.JTextField Phone;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
