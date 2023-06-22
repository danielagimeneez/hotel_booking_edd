/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import Funciones.Excel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import javax.swing.JTextArea;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Asdrubal Rivas
 */

public class Hashtable {

    public Entry[] table;
    public static final int TABLE_SIZE = 10; // Tamaño de la tabla de dispersión

    public Hashtable() {
        table = new Entry[TABLE_SIZE];
    }

    public void agregar(Object key, Object value) {
        int hash = getHash(key);
        Entry entry = table[hash];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }

        entry = new Entry(key, value);
        entry.setNext(table[hash]);
        table[hash] = entry;
    }

    public void buscarValor(Object key) {
        int hash = getHash(key);
        Entry entry = table[hash];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                
                System.out.println("El cliente " + key + " está hospedado en la habitación " + entry.getValue());
                
                return;
            }
            entry = entry.getNext();
        }
        
    }
    
    public void buscarValor2(Object key) {
    int hash = getHash(key);
    Entry entry = table[hash];

    while (entry != null) {
        if (entry.getKey().equals(key)) {
            Object value = entry.getValue();
        if (value == null) {
            System.out.println("La habitación " + key + " está libre");
        } else {
            System.out.println("El cliente " + key + " está hospedado en la habitación " + value);
        }
        return;
    }
        entry = entry.getNext();
    }

    System.out.println("El cliente " + key + " no existe");
}

    
    
    public void BusquedaDeReservacion(Object key) {
        int hash = getHash(key);
        Entry entry = table[hash];

        //while (entry != null) {
            if (entry.getKey().equals(key)) {
                // Realiza la búsqueda de reservación
                System.err.println("Si existe, el value es: "+entry.getValue());
                return;
            }
            entry = entry.getNext();
        }

        //System.out.println("El cliente " + key + " no existe");
    
    
    public void eliminarElemento(Object key) {
        int hash = getHash(key);
        Entry currentEntry = table[hash];
        Entry previousEntry = null;

        while (currentEntry != null) {
            if (currentEntry.getKey().equals(key)) {
                if (previousEntry == null) {
                    // El elemento a eliminar es el primer elemento de la cadena
                    table[hash] = currentEntry.getNext();
                } else {
                    // El elemento a eliminar está en el medio o al final de la cadena
                    previousEntry.setNext(currentEntry.getNext());
                }
                System.out.println("La habitación de " + currentEntry.getKey() + " quedó libre");
                return;
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.getNext();
        }

        System.out.println("El cliente " + key + " no existe");
    }

    public int getHash(Object key) {
        int hash = key.hashCode() % TABLE_SIZE;
        if (hash < 0) {
            hash += TABLE_SIZE;
        }
        return hash;
    }

    public static class Entry {
        public Object key;
        public Object value;
        public Entry next;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }
    
    public void imprimirKeys() {
    for (Entry entry : table) {
        while (entry != null) {
            System.out.println(entry.getKey());
            entry = entry.getNext();
        }
    }
}
    
    public void imprimirValues() {
    for (Entry entry : table) {
        while (entry != null) {
            Object[] values = (Object[]) entry.getValue();
            if (values != null) {
                for (Object value : values) {
                    if (value != null) {
                        System.out.println(value.toString());
                    } else {
                        System.out.println("Valor nulo");
                    }
                }
            } else {
                System.out.println("Valor nulo");
            }
            entry = entry.getNext();
        }
    }
}



    
    public void guardarElementosEnHashtable() {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try {
            FileInputStream fis = new FileInputStream(selectedFile);
            Workbook workbook = new XSSFWorkbook(fis);

            // Obtener la página 3 del libro de Excel
            Sheet sheet3 = workbook.getSheetAt(2);

            // Leer los elementos de las columnas 2 y 3 de la página 3 y utilizarlos como claves
            for (Row row : sheet3) {
                Cell cell2 = row.getCell(1); // Columna 2
                Cell cell3 = row.getCell(2); // Columna 3

                if (cell2 != null && cell3 != null) {
                    String key = cell2.getStringCellValue() + " " + cell3.getStringCellValue(); // Agregar espacio

                    // Obtener los elementos de la columna 1 de la página 3 y utilizarlos como valores
                    for (Row row2 : sheet3) {
                        Cell cell1 = row2.getCell(0); // Columna 1

                        if (cell1 != null) {
                            Object value = null;

                            switch (cell1.getCellType()) {
                                case STRING:
                                    value = cell1.getStringCellValue();
                                    break;
                                case NUMERIC:
                                    if (DateUtil.isCellDateFormatted(cell1)) {
                                        value = cell1.getDateCellValue();
                                    } else {
                                        value = cell1.getNumericCellValue();
                                    }
                                    break;
                                case BOOLEAN:
                                    value = cell1.getBooleanCellValue();
                                    break;
                            }

                            if (value != null) {
                                agregar(key, value);
                            }
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
    
    public void imprimirColumna1Pagina3() {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try {
            FileInputStream fis = new FileInputStream(selectedFile);
            Workbook workbook = new XSSFWorkbook(fis);

            // Obtener la página 3 del libro de Excel
            Sheet sheet3 = workbook.getSheetAt(2);

            // Leer los elementos de la columna 1 de la página 3 y imprimirlos
            for (Row row : sheet3) {
                Cell cell1 = row.getCell(0); // Columna 1

                if (cell1 != null) {
                    switch (cell1.getCellType()) {
                        case STRING:
                            System.out.println(cell1.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell1)) {
                                System.out.println(cell1.getDateCellValue());
                            } else {
                                System.out.println(cell1.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            System.out.println(cell1.getBooleanCellValue());
                            break;
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
    
   public void registros() {
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
                            agregar(key, value);
                            
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
   
   
   
   public void imprimirFilasDeExcel() {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try {
            FileInputStream fis = new FileInputStream(selectedFile);
            Workbook workbook = new XSSFWorkbook(fis);

            // Obtener la primera página del libro de Excel
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar por cada fila y cada celda e imprimir su valor
            for (Row row : sheet) {
                for (Cell cell : row) {
                    Object value = getCellValue(cell);
                    System.out.print(value + "\t");
                }
                System.out.println(); // Saltar a la siguiente línea después de imprimir una fila completa
            }

            workbook.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
}

public class RowValue {
    public Object[] values;

    public RowValue() {
        values = new Object[getTableSize()];
    }

    public void addValue(Object value) {
        int index = getAvailableIndex();
        values[index] = value;
    }

    public Object[] getValues() {
        return values;
    }

    public int getAvailableIndex() {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int getTableSize() {
        return TABLE_SIZE; // Tamaño de la tabla de dispersión
    }
}


public void guardarColumnaEnHashtable() {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try {
            FileInputStream fis = new FileInputStream(selectedFile);
            Workbook workbook = new XSSFWorkbook(fis);

            // Obtener la primera página del libro de Excel
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(0); // Obtener la celda en la primera columna

                if (cell != null) {
                    Object key = null;

                    switch (cell.getCellType()) {
                        case STRING:
                            key = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            key = cell.getNumericCellValue();
                            break;
                    }

                    if (key != null) {
                        
                        agregar(key, row);
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









    
public void mostrarClavesEnTextArea(JTextArea textArea) {
    for (Entry entry : table) {
        while (entry != null) {
            Object key = entry.getKey();
            if (!key.equals("primer_nombre apellido")) {
                textArea.append(key.toString() + "\n");
            }
            entry = entry.getNext();
        }
    }
}




public void imprimirKeysYValues() {
    for (Entry entry : table) {
        while (entry != null) {
            Object key = entry.getKey();
            Object[] values = (Object[]) entry.getValue();

            if (key != null && values != null) {
                System.out.println("Key: " + key.toString());
                for (Object value : values) {
                    if (value != null) {
                        System.out.println("Value: " + value.toString());
                    } else {
                        System.out.println("Value: Valor nulo");
                    }
                }
            }

            entry = entry.getNext();
        }
    }
}


public String getCellValueAsString(Cell cell) {
    switch (cell.getCellType()) {
        case STRING:
            return cell.getStringCellValue();
        case NUMERIC:
            return String.valueOf(cell.getNumericCellValue());
        case BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue());
        case FORMULA:
            return cell.getCellFormula();
        default:
            return "";
    }
}

public void obtenerDatosDesdeExcel() {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String filePath = selectedFile.getAbsolutePath();
        BusquedaReservacion(filePath);
    }
}

public void BusquedaReservacion(String filePath) {
    try {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        // Obtener la primera página de Excel (índice 0)
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            Cell firstCell = row.getCell(0); // Obtener la primera celda (columna 0)

            if (firstCell != null && firstCell.getCellType() == CellType.NUMERIC) {
                int key = (int) firstCell.getNumericCellValue();
                Object[] values = new Object[row.getLastCellNum() - 1];

                // Recorrer las celdas a la derecha de la primera celda
                for (int i = 1; i < row.getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    if (cell != null) {
                        Object value = getCellValue(cell);
                        values[i - 1] = value;
                    }
                }

                agregar(key, values);
            }
        }

        workbook.close();
        fis.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}



//public void BusquedaReservacion(String filePath) {
//    try {
//        FileInputStream fis = new FileInputStream(filePath);
//        Workbook workbook = WorkbookFactory.create(fis);
//
//        // Obtener la primera página de Excel (índice 0)
//        Sheet sheet = workbook.getSheetAt(0);
//
//        for (Row row : sheet) {
//            Cell firstCell = row.getCell(0); // Obtener la primera celda (columna 0)
//
//            if (firstCell != null) {
//                String key = getCellValueAsString(firstCell);
//                Object[] values = new Object[row.getLastCellNum() - 1];
//
//                // Recorrer las celdas a la derecha de la primera celda
//                for (int i = 1; i < row.getLastCellNum(); i++) {
//                    Cell cell = row.getCell(i);
//                    if (cell != null) {
//                        Object value = getCellValue(cell);
//                        values[i - 1] = value;
//                    }
//                }
//
//                agregar(key, values);
//            }
//        }
//
//        workbook.close();
//        fis.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}

public void BuscarPorCedula(int key) {
    

    int hash = getHash(key);
    Entry entry = table[hash];

    while (entry != null) {
        if (entry.getKey().equals(key)) {
            Object[] values = (Object[]) entry.getValue();

            if (values != null) {
                StringBuilder message = new StringBuilder();
                message.append("Ese cliente posee estos datos: ").append(key).append(":\n");

                for (Object value : values) {
                    if (value != null) {
                        message.append(value.toString()).append("\n");
                    } else {
                        message.append("");
                    }
                }

                JOptionPane.showMessageDialog(null, message.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Ese cliente no se ha registrado");
            }

            return;
        }
        entry = entry.getNext();
    }

    JOptionPane.showMessageDialog(null, "No existe ningun cliente que posea la cedula "+key);
}





    
}








   

    


   
   


    


    








    


    
    

   
