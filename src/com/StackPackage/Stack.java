package com.StackPackage;

import com.ListaEnlazada.ListaEnlazada;
import com.RecetasManager.Receta;

public class Stack {
    /***
     * Stack class
     * @author Oscar Méndez
     * @author Keyner Gómez
     * @author Marco Picado
     * @author Hansel Hampton
     */

        //Instancia//
        private ListaEnlazada<Receta> stackList = new ListaEnlazada<Receta>();


        /***
         * Método push
         * Agregar datos a la pila
         * @param data
         */
        public void push(Receta data){
            this.stackList.addCabeza(data);
        }
        /***
         * Sacar y eliminar elementos de la cola
         * @return
         */
        public Object pop(){
            return this.stackList.removeFirst().getData();
        }
        /***
         * Método peek
         * Ver el primer elemento en la pila
         * @return
         */
        public Receta peek(){
            return stackList.getCabeza();
        }
        /***
         * Método isEmpty
         * Verifica que el stack no esté vacío
         * @return boolean
         */
        public boolean isEmpty(){
            return this.stackList.isEmpty();
        }

    public void setStackList(ListaEnlazada<Receta> stackList) {
        this.stackList = stackList;
    }
}
