package com.Recetas;

import com.ListaEnlazada.ListaEnlazada;

public class Receta {
	private String nombre;
	private String autor;
	private String tipo;
	private int porciones;
	private String tiempo;
	private int dificultad;
	private String dieta;
	//FOTO//
	private ListaEnlazada<String> ingredientes;//OPTATIVO
	private String pasos;
	private int precio;
	
	
	
	
	public Receta() {
		ingredientes = new ListaEnlazada<String>();
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPorciones() {
		return porciones;
	}
	public void setPorciones(int porciones) {
		this.porciones = porciones;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	public String getDieta() {
		return dieta;
	}
	public void setDieta(String dieta) {
		this.dieta = dieta;
	}
	public String getPasos() {
		return pasos;
	}
	public void setPasos(String pasos) {
		this.pasos = pasos;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public void addIngredientes() {
		
		
	}
	
}
