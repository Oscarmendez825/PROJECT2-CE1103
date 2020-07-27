package com.ListaEnlazada;
/***
 * Node class for the linked list.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class Nodo <Type> {
    private Type data;
    private Nodo next;

    /***
     * First constructor method of the Nodo class.
     * @param data Type
     */
    public Nodo(Type data){
        this.data = data;
        this.next = null;
    }
    /***
     * Second constructor method of the Nodo class.
     */
    public Nodo() {
        this.data = data;
        this.next = null;
    }
    /***
     * This method returns the 'data' variable.
     * @return Type
     */
    public Type getData(){
        return this.data;

    }
    /***
     * This method changes the value of the 'data' variable.
     * @param data Type
     */
    public void setData(Type data){
        this.data = data;

    }
    /***
     * This method returns the 'next' variable.
     * @return Nodo
     */
    public Nodo getNext(){
        return this.next;
    }
    /***
     * This method changes the value of the 'next' variable.
     * @param nodo Nodo
     */
    public void setNext(Nodo nodo){
        this.next = nodo;

    }
}
