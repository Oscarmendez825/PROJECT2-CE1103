package com.StackPackage;

import com.ListaEnlazada.ListaEnlazada;
import com.RecetasManager.Receta;
/***
 * Stack class; used on the NewsFeed of each user.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class Stack {


        //Instancia//
        private ListaEnlazada<Receta> stackList = new ListaEnlazada<Receta>();



    /***
     * This method adds an item at the top of the stack.
     * @param data Receta
     */
        public void push(Receta data){
            this.stackList.addCabeza(data);
        }
    /***
     * This method removes an item from the top of the stack.
     * @return Object
     */
        public Object pop(){
            return this.stackList.removeFirst().getData();
        }
    /***
     * This method obtains te item at the top of the stack.
     * @return Receta
     */
        public Receta peek(){
            return stackList.getCabeza();
        }
    /***
     * This method verifies if the stack is empty.
     * @return Boolean
     */
        public boolean isEmpty(){
            return this.stackList.isEmpty();
        }


}
