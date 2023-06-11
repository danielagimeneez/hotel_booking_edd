/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

/**
 *
 * @author Asdrubal Rivas
 */

public class Hashtable {

    private Entry[] table;
    private static final int TABLE_SIZE = 10; // Tamaño de la tabla de dispersión

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

        System.out.println("El cliente " + key + " no existe");
    }
    
    public void BusquedsaDeReservacion(Object key) {
        int hash = getHash(key);
        Entry entry = table[hash];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                
                return;
            }
            entry = entry.getNext();
        }

        System.out.println("El cliente " + key + " no existe");
    }
    

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

    private int getHash(Object key) {
        int hash = key.hashCode() % TABLE_SIZE;
        if (hash < 0) {
            hash += TABLE_SIZE;
        }
        return hash;
    }

    private static class Entry {
        private Object key;
        private Object value;
        private Entry next;

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
}

