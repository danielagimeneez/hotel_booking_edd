/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import HashTable.Hashtable;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Asdrubal Rivas
 */
public class BusquedaDeReserva extends javax.swing.JFrame {

    /**
     * Creates new form BusquedaDeReserva
     */
    public BusquedaDeReserva() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Cedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cargar Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingresar la cedula del cliente");

        Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulaActionPerformed(evt);
            }
        });

        jLabel2.setText("Pon la cedula sin puntos. Por ejemplo: 28101757");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(321, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel1)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(21, 21, 21))
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


    public void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if ("".equals(Cedula.getText())){
            JOptionPane.showMessageDialog(rootPane, "No escribiste nada..");
        }else{
            Hashtable hashtable = new Hashtable();
            hashtable.obtenerDatosDesdeExcel();
            String key = Cedula.getText();
            int keys = Integer.parseInt(key);
            hashtable.imprimirKeys();
                hashtable.BuscarPorCedula(keys);
            }
        
        
        
                                    //-----------------------------------------------IMPRIMIR TODOS LOS DATOS-----------------------------------------------
                                    
//        JFileChooser fileChooser = new JFileChooser();
//
//        // Mostrar el diálogo de selección de archivo
//        int result = fileChooser.showOpenDialog(null);
//
//        if (result == JFileChooser.APPROVE_OPTION) {
//            // Obtener el archivo seleccionado
//            File selectedFile = fileChooser.getSelectedFile();
//
//            try {
//                // Cargar el archivo de Excel seleccionado
//                FileInputStream fis = new FileInputStream(selectedFile);
//                Workbook workbook = new XSSFWorkbook(fis);
//
//                // Obtener la primera página de Excel (índice 0)
//                Sheet sheet = workbook.getSheetAt(0);
//
//                // Iterar sobre todas las filas y columnas de la primera página
//                for (Row row : sheet) {
//                    for (Cell cell : row) {
//                        switch (cell.getCellType()) {
//                            case STRING:
//                                String stringValue = cell.getStringCellValue();
//                                System.out.print(stringValue + "\t");
//                                break;
//                            case NUMERIC:
//                                double numericValue = cell.getNumericCellValue();
//                                System.out.print(numericValue + "\t");
//                                break;
//                            case BOOLEAN:
//                                boolean booleanValue = cell.getBooleanCellValue();
//                                System.out.print(booleanValue + "\t");
//                                break;
//                            default:
//                                System.out.print("\t");
//                        }
//                    }
//                    System.out.println();
//                }
//
//                // Cerrar el archivo
//                workbook.close();
//                fis.close();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
                                    //-----------------------------------------------IMPRIMIR TODOS LOS DATOS-----------------------------------------------

    
        
    
        
                            //-----------------------------------------------IMPRIMIR Y BUSCAR CEDULAS-----------------------------------------------

//        JFileChooser fileChooser = new JFileChooser();
//
//        // Mostrar el diálogo de selección de archivo
//        int result = fileChooser.showOpenDialog(null);
//
//        if (result == JFileChooser.APPROVE_OPTION) {
//            // Obtener el archivo seleccionado
//            File selectedFile = fileChooser.getSelectedFile();
//
//            try {
//                // Cargar el archivo de Excel seleccionado
//                FileInputStream fis = new FileInputStream(selectedFile);
//                Workbook workbook = new XSSFWorkbook(fis);
//
//                // Obtener la primera página de Excel (índice 0)
//                Sheet sheet = workbook.getSheetAt(0);
//
//                // Imprimir el contenido de la primera columna
//                System.out.println("Contenido de la primera columna:");
//                for (int i = 1; i <= 1000; i++) {
//                    Row row = sheet.getRow(i);
//
//                    if (row != null) {
//                        Cell cell = row.getCell(0); // Obtener la primera celda (columna A)
//
//                        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
//                            double numericValue = cell.getNumericCellValue();
//                            System.out.println(numericValue);
//                        }
//                    }
//                }
//
//                // Pedir al usuario el contenido a buscar
//                System.out.println("\nIngrese el contenido a buscar en la primera columna:");
//                Scanner scanner = new Scanner(System.in);
//                double contenidoBuscado = scanner.nextDouble();
//
//                boolean existeContenido = false;
//
//                // Buscar el contenido en la primera columna (desde A2 hasta A1001)
//                for (int i = 1; i <= 1000; i++) {
//                    Row row = sheet.getRow(i);
//
//                    if (row != null) {
//                        Cell cell = row.getCell(0); // Obtener la primera celda (columna A)
//
//                        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
//                            double cellValue = cell.getNumericCellValue();
//
//                            if (cellValue == contenidoBuscado) {
//                                existeContenido = true;
//                                break;
//                            }
//                        }
//                    }
//                }
//
//                // Cerrar el archivo
//                workbook.close();
//                fis.close();
//
//                if (existeContenido) {
//                    System.out.println("El contenido " + contenidoBuscado + " existe en la primera columna.");
//                } else {
//                    System.out.println("El contenido " + contenidoBuscado + " no existe en la primera columna.");
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        
                            //-----------------------------------------------IMPRIMIR Y BUSCAR CEDULAS-----------------------------------------------

    
    
    
    
    
            
            




        
                //-----------------------------------------------IMPRIMIR CEDULAS-----------------------------------------------

//        JFileChooser fileChooser = new JFileChooser();
//
//        // Mostrar el diálogo de selección de archivo
//        int result = fileChooser.showOpenDialog(null);
//
//        if (result == JFileChooser.APPROVE_OPTION) {
//            // Obtener el archivo seleccionado
//            File selectedFile = fileChooser.getSelectedFile();
//
//            try {
//                // Cargar el archivo de Excel seleccionado
//                FileInputStream fis = new FileInputStream(selectedFile);
//                Workbook workbook = new XSSFWorkbook(fis);
//
//                // Obtener la primera página de Excel (índice 0)
//                Sheet sheet = workbook.getSheetAt(0);
//
//                // Iterar sobre las filas
//                for (Row row : sheet) {
//                    Cell cell = row.getCell(0); // Obtener la primera celda
//
//                    if (cell != null) {
//                        if (cell.getCellType() == CellType.STRING) {
//                            String cellValue = cell.getStringCellValue();
//
//                            // Eliminar la cadena "E7" del contenido
//                            if (cellValue.contains("E7")) {
//                                cellValue = cellValue.replace("E7", "");
//                            }
//
//                            System.out.println(cellValue.trim());
//                        } else if (cell.getCellType() == CellType.NUMERIC) {
//                            System.out.println(cell.getNumericCellValue());
//                        } else if (cell.getCellType() == CellType.BOOLEAN) {
//                            System.out.println(cell.getBooleanCellValue());
//                        }
//                    }
//                }
//
//                // Cerrar el archivo
//                workbook.close();
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        
        //-----------------------------------------------IMPRIMIR CEDULAS-----------------------------------------------
    }//GEN-LAST:event_jButton2ActionPerformed

    public void CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CedulaActionPerformed

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
            java.util.logging.Logger.getLogger(BusquedaDeReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaDeReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaDeReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaDeReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaDeReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cedula;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
