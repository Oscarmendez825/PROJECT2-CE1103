package com.ListaEnlazada;

public class Nodo <Type>{

	private Type data;
    private Nodo next;
    
    
    public Nodo(Type data){
        this.data = data;
        this.next = null;
    }
    public Nodo() {
        this.data = data;
        this.next = null;
    }
    public Type getData(){
        return this.data;
    
    }
    public void setData(Type data){
        this.data = data;
    
    }
    public Nodo getNext(){
        return this.next;
    }
    public void setNext(Nodo nodo){
        this.next = nodo;
    
    }
}

