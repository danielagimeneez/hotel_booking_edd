/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import Funciones.Excel;
import HashTable.Hashtable;
import HashTable.Hashtable.Entry;
import org.apache.poi.ss.usermodel.*;
import javax.swing.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;



/**
 *
 * @author Asdrubal Rivas
 */
public class Registrar extends javax.swing.JFrame {

    /**
     * Creates new form Registrar
     */
    public Registrar() {
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

        Regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClientesImprimir = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ApellidoBuscar = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        jLabel1.setText("Clientes en el hotel");

        jButton1.setText("Cargar excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ClientesImprimir.setColumns(20);
        ClientesImprimir.setRows(5);
        jScrollPane1.setViewportView(ClientesImprimir);

        jLabel2.setText("Ingrese el nombre y apellido del cliente");

        jLabel3.setText("para saber el numero de la habitacion se encuentra");

        ApellidoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidoBuscarActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regresar)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Buscar)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(ApellidoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Regresar)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ApellidoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Buscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        // TODO add your handling code here:
        dispose();
        VentanaPrincipal MainMenu = new VentanaPrincipal();
        MainMenu.setLocationRelativeTo(null);
        MainMenu.setSize(600, 400);
        MainMenu.setResizable(false);
        MainMenu.setTitle("Hotel");
        MainMenu.setVisible(true);
    }//GEN-LAST:event_RegresarActionPerformed

    public void registros2() {
    Hashtable hashtable = new Hashtable();
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try {
            FileInputStream fis = new FileInputStream(selectedFile);
            Workbook workbook = new XSSFWorkbook(fis);

            // Obtener la tercera página de Excel (índice 2)
            Sheet sheet = workbook.getSheetAt(2);

            for (Row row : sheet) {
                Cell cell2 = row.getCell(1); // Obtener la segunda celda (columna 2)
                Cell cell3 = row.getCell(2); // Obtener la tercera celda (columna 3)
                Cell cell1 = row.getCell(0); // Obtener la primera celda (columna 1)

                if (cell2 != null && cell3 != null && cell1 != null) {
                    Object key = null;
                    Object value = null;

                    switch (cell2.getCellType()) {
                        case STRING:
                            key = cell2.getStringCellValue();
                            break;
                        case NUMERIC:
                            key = cell2.getNumericCellValue();
                            break;
                    }

                    switch (cell3.getCellType()) {
                        case STRING:
                            key += " " + cell3.getStringCellValue();
                            break;
                        case NUMERIC:
                            key += " " + cell3.getNumericCellValue();
                            break;
                    }

                    switch (cell1.getCellType()) {
                        case STRING:
                            value = cell1.getStringCellValue();
                            break;
                        case NUMERIC:
                            value = cell1.getNumericCellValue();
                            break;
                    }

                    if (key != null) {
                        if (value == null) {
                            System.out.println("La habitación " + key + " está libre");
                        } else {
                            hashtable.agregar(key, value);
                            hashtable.mostrarClavesEnTextArea(ClientesImprimir);
                        }
                    }
                }
            }

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


    
    
    public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Aqui importe Scanner para probar los input.. No se porque esta fastidioso copiarlo a un JTextFile :(
        //Hay que imprimir todos los nombres y apellidos en ese JTextFile y ponerlos en el HashTable.. la key podria ser el nombre y el apellido
        //Y el value pordia ser el num de habitacion
        registros2();
    }

public Object getCellValue(Cell cell) {
    switch (cell.getCellType()) {
        case STRING:
            return cell.getStringCellValue();
        case NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getDateCellValue();
            } else {
                return cell.getNumericCellValue();
            }
        case BOOLEAN:
            return cell.getBooleanCellValue();
        default:
            return null;
    }

        
                        //---------------------------------------------- BUSCAR EL NUMERO DE HABITACION -----------------------------------------------------
                
        
                //---------------------------------------------- BUSCAR EL NUMERO DE HABITACION -----------------------------------------------------

        
        
                //---------------------------------------------- BUSCAR EL APELLIDO DEL CLIENTE -----------------------------------------------------

//        JFileChooser fileChooser = new JFileChooser();
//
//        // Mostrar el dialogo de selección de archivo
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
//                // Obtener la primera hoja de Excel
//                Sheet sheet = workbook.getSheetAt(0);
//
//                // Obtener el contenido a buscar del usuario
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("Ingrese el contenido a buscar: ");
//                String contenidoBuscado = scanner.nextLine();
//
//                boolean encontrado = buscarContenidoEnExcel(sheet, contenidoBuscado);
//
//                if (encontrado) {
//                    System.out.println("Si se encontro.");
//                } else {
//                    System.out.println("No se encontro.");
//                }
//
//                // Cerrar el archivo
//                workbook.close();
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static boolean buscarContenidoEnExcel(Sheet sheet, String contenido) {
//        // Iterar sobre las filas
//        for (Row row : sheet) {
//            Cell cellB = row.getCell(1); // Obtener la celda B
//            Cell cellC = row.getCell(2); // Obtener la celda C
//
//            if (cellB != null && cellC != null && cellB.getCellType() == CellType.STRING && cellC.getCellType() == CellType.STRING) {
//                String cellValueB = cellB.getStringCellValue();
//                String cellValueC = cellC.getStringCellValue();
//
//                if (cellValueB.equals(contenido) || cellValueC.equals(contenido)) {
//                    return true; // Se encontró el contenido en el archivo de Excel
//                }
//            }
//        }
//
//        return false; // No se encontró el contenido en el archivo de Excel
                        //---------------------------------------------- BUSCAR EL APELLIDO DEL CLIENTE -----------------------------------------------------

    
        
        //---------------------------------------------- BUSCAR EL NOMBRE DEL CLIENTE -----------------------------------------------------
//        JFileChooser fileChooser = new JFileChooser();
//
//        // Mostrar el dialogo de selección de archivo
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
//                // Obtener la primera hoja de Excel
//                Sheet sheet = workbook.getSheetAt(0);
//
//                // Obtener el contenido a buscar del usuario
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("Ingrese el contenido a buscar: ");
//                String contenidoBuscado = scanner.nextLine();
//
//                boolean encontrado = buscarContenidoEnExcel(sheet, contenidoBuscado);
//
//                if (encontrado) {
//                    System.out.println("Se encontro.");
//                } else {
//                    System.out.println("No se encontro.");
//                }
//
//                // Cerrar el archivo
//                workbook.close();
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static boolean buscarContenidoEnExcel(Sheet sheet, String contenido) {
//        // Iterar sobre las filas
//        for (Row row : sheet) {
//            // Iterar sobre las celdas de la fila
//            for (Cell cell : row) {
//                if (cell != null && cell.getCellType() == CellType.STRING) {
//                    String cellValue = cell.getStringCellValue();
//                    if (cellValue.equals(contenido)) {
//                        return true; // Se encontro el contenido en el archivo de Excel
//                    }
//                }
//            }
//        }
//
//        return false; // No se encontro el contenido en el archivo de Excel
            //---------------------------------------------- BUSCAR EL NOMBRE DEL CLIENTE -----------------------------------------------------

        
        //---------------------------------------------- IMPRIMIR TODOS LOS CLIENTES-----------------------------------------------------
//        JFileChooser fileChooser = new JFileChooser();
//
//        // Mostrar el dialogo de selección de archivo
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
//                // Obtener la primera hoja de Excel
//                Sheet sheet = workbook.getSheetAt(0);
//
//                // Iterar sobre las filas y obtener el contenido de las columnas B y C
//                for (Row row : sheet) {
//                    Cell cellB = row.getCell(1); // Obtener la celda B
//                    Cell cellC = row.getCell(2); // Obtener la celda C
//
//                    if (cellB != null && cellC != null) {
//                        switch (cellB.getCellType()) {
//                            case STRING:
//                                ClientesImprimir.
//                                System.out.print(cellB.getStringCellValue() + "\t");
//                                break;
//                            case NUMERIC:
//                                System.out.print(cellB.getNumericCellValue() + "\t");
//                                break;
//                            case BOOLEAN:
//                                System.out.print(cellB.getBooleanCellValue() + "\t");
//                                break;
//                            case BLANK:
//                                System.out.print("\t");
//                                break;
//                            default:
//                                System.out.print("\t");
//                        }
//
//                        switch (cellC.getCellType()) {
//                            case STRING:
//                                System.out.println(cellC.getStringCellValue());
//                                break;
//                            case NUMERIC:
//                                System.out.println(cellC.getNumericCellValue());
//                                break;
//                            case BOOLEAN:
//                                System.out.println(cellC.getBooleanCellValue());
//                                break;
//                            case BLANK:
//                                System.out.println("");
//                                break;
//                            default:
//                                System.out.println("");
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








//JFileChooser fileChooser = new JFileChooser();
//int result = fileChooser.showOpenDialog(null);
//
//if (result == JFileChooser.APPROVE_OPTION) {
//    File selectedFile = fileChooser.getSelectedFile();
//
//    try {
//        FileInputStream fis = new FileInputStream(selectedFile);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        StringBuilder sb = new StringBuilder();
//
//        int contador = 0;
//
//        for (Row row : sheet) {
//            Cell cellB = row.getCell(1);
//            Cell cellC = row.getCell(2);
//
//            if (cellB != null && cellC != null) {
//                switch (cellB.getCellType()) {
//                    case STRING:
//                        sb.append(cellB.getStringCellValue()).append("\t");
//                        break;
//                    case NUMERIC:
//                        sb.append(cellB.getNumericCellValue()).append("\t");
//                        break;
//                    case BOOLEAN:
//                        sb.append(cellB.getBooleanCellValue()).append("\t");
//                        break;
//                    case BLANK:
//                        sb.append("\t");
//                        break;
//                    default:
//                        sb.append("\t");
//                }
//
//                switch (cellC.getCellType()) {
//                    case STRING:
//                        sb.append(cellC.getStringCellValue());
//                        break;
//                    case NUMERIC:
//                        sb.append(cellC.getNumericCellValue());
//                        break;
//                    case BOOLEAN:
//                        sb.append(cellC.getBooleanCellValue());
//                        break;
//                    case BLANK:
//                        break;
//                    default:
//                        break;
//                }
//
//                contador++;
//
//                if (contador % 1 == 0) {
//                    sb.append("\n\n");
//                } else {
//                    sb.append("\n");
//                }
//            }
//        }
//
//        workbook.close();
//        fis.close();
//
//        ClientesImprimir.setText(sb.toString());
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}



        //---------------------------------------------- IMPRIMIR TODOS LOS CLIENTES-----------------------------------------------------
        
    
    }//GEN-LAST:event_jButton1ActionPerformed

    public void ApellidoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidoBuscarActionPerformed

    public void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
        Hashtable hashtable = new Hashtable();
        //hashtable.guardarElementosEnHashtable();
        hashtable.registros();
        hashtable.imprimirValues();
        //hashtable.imprimirKeys();
        //Falta decir cuando la habitacion esta vacia y cuando no
        String juan = ApellidoBuscar.getText();
        hashtable.buscarValor2(juan);
        
        
        
        //IMPRIMIR TODA LA COLUMNA SOLO IMPRIME LA PRIMERA CELDA
        //Numero de hab:
        //readExcelSecondColumn();
        //Nombres:
        //printSecondColumnElements();

    }//GEN-LAST:event_BuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellidoBuscar;
    private javax.swing.JButton Buscar;
    public javax.swing.JTextArea ClientesImprimir;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
