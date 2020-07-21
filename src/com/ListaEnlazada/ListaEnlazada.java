package com.ListaEnlazada;

/***
 * Linked list class; used for the MyMenu of each user.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class ListaEnlazada <Type>{
    private Nodo first;
    private Nodo last;
    private int size = 0;

    /***
     * Constructor of the 'ListaEnlazada' class.
     */
    public ListaEnlazada(){
        this.first = null;
        this.last = null;
    }

    /***
     * This method verifies if the list is empty.
     * @return Boolean
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    /***
     * This method adds a new item to the list.
     * @param data Type
     */
    public void add(Type data) {
        Nodo<Type> nuevo = new Nodo<Type>();
        nuevo.setData(data);
        if (isEmpty()){
            first = nuevo;
            first.setNext(null);
            last = first;
        }else{
            last.setNext(nuevo);
            nuevo.setNext(null);
            last = nuevo;

        }
        size++;
    }

    /***
     * This method verifies if a item is in the list.
     * @param data Type
     * @return Boolean
     */
    public boolean search(Type data){
        Nodo nodo;
        nodo = first;
        while(nodo != null){
            if(nodo.getData().equals(data)){
                return true;
            }else {
                nodo = nodo.getNext();
            }

        }
        return false;
    }

    /***
     * This method removes a whole section from the list, from a certain position to the tail of the list.
     * @param pos Integer
     */
    public void cut(int pos){
        int cont = 0;
        Nodo aux = first;
        while (cont < pos-1){
            aux = aux.getNext();
            cont++;

        }
        aux.setNext(null);
        size = pos;

    }

    /***
     * This method prints all the items in the list.
     */
    public void show(){
        Nodo c = this.first;
        while(c != null){
            System.out.println(c.getData());
            c = c.getNext();
        }

    }

    /***
     * This method modifies the content of a certain position in the list.
     * @param pos Integer
     * @param data Type
     */
    public void modify(int pos, Type data){
        if (isEmpty()){
            System.out.println("Error su lista está vacía");

        }else{
            if (pos == 0){
                first.setData(data);

            }else{
                if(pos > 0 && pos < size){

                    Nodo aux = first;
                    int cont = 0;
                    while(true){
                        if (cont == pos){
                            aux.setData(data);
                            break;
                        }else{
                            aux = aux.getNext();
                            cont++;
                        }

                    }
                }else{
                    System.out.println("Error ingreso una posicion equivocada");
                }
            }
        }

    }

    /***
     * This method deletes an item from the list.
     * @param pos Integer
     */
    public void remove(int pos) {
        Nodo temp = first;
        Nodo aux = null;
        if (pos == 0){
            first = first.getNext();

        }else if(pos == this.size-1){
            int cont = 0;
            while(cont != this.size-1 ){
                cont++;
                aux = temp;
                temp = temp.getNext();

            }
            last = aux;
            aux.setNext(null);
        }else{
            int cont = 0;
            while(true){
                if (cont == pos){
                    aux.setNext(temp.getNext());
                    break;

                }else{
                    cont++;
                    aux = temp;
                    temp = temp.getNext();
                }

            }

        }
        size--;

    }

    /***
     * This method deletes all the elements with a common content from the list.
     * @param data Type
     * @return Nodo
     */
    public Nodo removeByValue(Type data){
        Nodo temp = this.first;
        Nodo previous = this.first;
        while(temp!=null){
            if(temp.getData().equals(data)){
                if (temp == this.first){
                    this.first = this.first.getNext();

                }else{
                    previous.setNext(temp.getNext());
                }
                return temp;


            }else{
                previous = temp;
                temp = temp.getNext();
            }

        }
        return null;
    }

    /***
     * This method returns the content of a certain position in the list.
     * @param pos Integer
     * @return Type
     */
    public Type get(int pos) {
        int cont = 0;
        Nodo temp = first;
        while(cont < pos){
            temp = temp.getNext();
            cont++;
        }
        return (Type) temp.getData();
    }

    /***
     * This method returns the content of the first node of the list.
     * @return Type
     */
    public Type getCabeza() {
        return (Type) first.getData();
    }

    /***
     * This method returns the content of the last node of the list.
     * @return Type
     */
    public Type getCola() {
        return (Type) last.getData();
    }

    /***
     * This method returns the size of the list.
     * @return Integer
     */
    public int getSize() {
        return size;
    }

    /***
     * This method adds a new node at the head of the list.
     * @param data Type
     */
    public void addCabeza(Type data){
        Nodo <Type> nuevo = new Nodo<Type>(data);
        if(isEmpty()){
            this.first = this.last = nuevo;

        }else{
            nuevo.setNext(this.first);
            this.first = nuevo;
        }

    }

    /***
     * This method removes the first node of the list.
     * @return Nodo
     */
    public Nodo removeFirst(){
        if (this.first != null) {
            Nodo temp = this.first;
            this.first = this.first.getNext();
            this.size--;
            return  temp;
        } else {
            return null;
        }
    }
}
