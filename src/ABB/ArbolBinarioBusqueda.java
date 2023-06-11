/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABB;

/**
 *
 * @author Asdrubal Rivas
 */

class ArbolBinarioBusqueda {
    Nodo raiz;

    ArbolBinarioBusqueda() {
        raiz = null;
    }

    void insertar(int valor) {
        raiz = insertarNodo(raiz, valor);
    }

    Nodo insertarNodo(Nodo nodo, int valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarNodo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarNodo(nodo.derecho, valor);
        }

        return nodo;
    }

    void imprimirOrdenPreOrder() {
        imprimirOrdenPreOrderRec(raiz);
    }

    void imprimirOrdenPreOrderRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            imprimirOrdenPreOrderRec(nodo.izquierdo);
            imprimirOrdenPreOrderRec(nodo.derecho);
        }
    }
}

