/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import HashTable.Hashtable;

/**
 *
 * @author Asdrubal Rivas
 */
public class Excel {
    //Mostrar todas las habitaciones para el Check-In
    //public static void imprimirColumnaNumericaPagina3() {
        // Crear un objeto JFileChooser
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
//                // Obtener la tercera hoja de Excel
//                Sheet sheet = workbook.getSheetAt(2); // Índice 2 para la tercera hoja (página 3)
//
//                // Imprimir el contenido de la primera columna numérica
//                for (Row row : sheet) {
//                    Cell cell = row.getCell(0); // Columna A (índice 0)
//                    if (cell != null && cell.getCellType() == CellType.NUMERIC) {
//                        // Obtener el valor numérico de la celda y mostrarlo
//                        double numericValue = cell.getNumericCellValue();
//                        System.out.println(numericValue);
//                    }
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
//    }

    //FUNCION PARA SABER SI ESTA VACIA O NO

//    public static void verificarNumeroEnColumnaPagina3(int numero) {
//        // Crear un objeto JFileChooser
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
//                // Obtener la tercera hoja de Excel
//                Sheet sheet = workbook.getSheetAt(2); // Índice 2 para la tercera hoja (página 3)
//
//                // Obtener el número de la columna (por ejemplo, columna A)
//                int columna = 0;
//
//                // Recorrer todas las filas de la columna especificada
//                for (Row row : sheet) {
//                    Cell cell = row.getCell(columna);
//
//                    if (cell != null && cell.getCellType() == CellType.NUMERIC) {
//                        double valorCelda = cell.getNumericCellValue();
//
//                        // Verificar si el número dado existe en la columna
//                        if (valorCelda == numero) {
//                            JOptionPane.showMessageDialog(fileChooser, ("La habitacion " + numero + " no esta disponible"));
//                            return;
//                        }
//                    }
//                }
//
//                JOptionPane.showMessageDialog(fileChooser, ("La habitacion " + numero + " Esta disponible"));
//                JOptionPane.showMessageDialog(fileChooser, "El usuario ha sido creado exitosamente");
//
//                // Cerrar el archivo
//                workbook.close();
//                fis.close();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        
//        
//
//        
//}
    
    public static boolean verificarNumeroEnColumnaPagina3(int numero) {
    // Crear un objeto JFileChooser
    JFileChooser fileChooser = new JFileChooser();

    // Mostrar el diálogo de selección de archivo
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        // Obtener el archivo seleccionado
        File selectedFile = fileChooser.getSelectedFile();

        try {
            // Cargar el archivo de Excel seleccionado
            FileInputStream fis = new FileInputStream(selectedFile);
            Workbook workbook = new XSSFWorkbook(fis);

            // Obtener la tercera hoja de Excel
            Sheet sheet = workbook.getSheetAt(2); // Índice 2 para la tercera hoja (página 3)

            // Obtener el número de la columna (por ejemplo, columna A)
            int columna = 0;

            // Recorrer todas las filas de la columna especificada
            for (Row row : sheet) {
                Cell cell = row.getCell(columna);

                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    double valorCelda = cell.getNumericCellValue();

                    // Verificar si el número dado existe en la columna
                    if (valorCelda == numero) {
                        workbook.close();
                        fis.close();
                        return false;
                    }
                }
            }

            // Cerrar el archivo
            workbook.close();
            fis.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    return false;
}
    //Num hab
    public static Object readExcelSecondColumn() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                FileInputStream fis = new FileInputStream(selectedFile);
                Workbook workbook = new XSSFWorkbook(fis);
                Sheet sheet = workbook.getSheetAt(1);

                for (Row row : sheet) {
                    Cell cell = row.getCell(0); // Primera celda

                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                return cell.getStringCellValue();
                            case NUMERIC:
                                return cell.getNumericCellValue();
                            case BOOLEAN:
                                return cell.getBooleanCellValue();
                        }
                    }
                }

                workbook.close();
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    //Apellidos
    public static Object printSecondColumnElements() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                FileInputStream fis = new FileInputStream(selectedFile);
                Workbook workbook = new XSSFWorkbook(fis);
                Sheet sheet = workbook.getSheetAt(0);

                for (Row row : sheet) {
                    Cell cell = row.getCell(1); // Segunda columna

                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                return cell.getStringCellValue();
                            case NUMERIC:
                                return cell.getNumericCellValue();
                            case BOOLEAN:
                                return cell.getBooleanCellValue();
                        }
                    }
                }

                workbook.close();
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    
   

    

        
}
