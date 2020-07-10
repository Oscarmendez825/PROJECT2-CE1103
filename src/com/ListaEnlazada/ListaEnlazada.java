package com.ListaEnlazada;

public class ListaEnlazada <Type>{
    private Nodo first;
    private Nodo last;
    private int size = 0;

    public ListaEnlazada(){
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

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

    public void show(){
        Nodo c = this.first;
        while(c != null){
            System.out.println(c.getData());
            c = c.getNext();
        }

    }

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
    public Type get(int pos) {
        int cont = 0;
        Nodo temp = first;
        while(cont < pos){
            temp = temp.getNext();
            cont++;
        }
        return (Type) temp.getData();
    }



    public Type getCabeza() {
        return (Type) first.getData();
    }

    public Type getCola() {
        return (Type) last.getData();
    }

    public int getSize() {
        return size;
    }

    public void addCabeza(Type data){
        Nodo <Type> nuevo = new Nodo<Type>(data);
        if(isEmpty()){
            this.first = this.last = nuevo;

        }else{
            nuevo.setNext(this.first);
            this.first = nuevo;
        }

    }
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
