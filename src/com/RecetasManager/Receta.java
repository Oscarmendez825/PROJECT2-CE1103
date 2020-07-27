package com.RecetasManager;
/***
 * Recipes class; this class is the template for the creation of 'Receta' objects.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class Receta {
    private String name;
    private String autor;
    private String tipoPlato;
    private int porciones;
    private String duracion;
    private String tiempo;
    private int dificultad;
    private String[] dieta;
    private String[] ingredientes;
    private String[] pasos;
    private int calificacion = 0;
    private int dia;
    private int mes;
    /***
     * This method returns the 'name' variable.
     * @return String
     */
    public String getName() {
        return name;
    }
    /***
     * This method changes the value of the 'name' variable.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }
    /***
     * This method returns the 'autor' variable.
     * @return String
     */
    public String getAutor() {
        return autor;
    }
    /***
     * This method changes the value of the 'autor' variable.
     * @param autor String
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /***
     * This method returns the 'tipoPlato' variable.
     * @return String
     */
    public String getTipoPlato() {
        return tipoPlato;
    }
    /***
     * This method changes the value of the 'tipoPlato' variable.
     * @param tipoPlato String
     */
    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }
    /***
     * This method returns the 'porciones' variable.
     * @return Integer
     */
    public int getPorciones() {
        return porciones;
    }
    /***
     * This method changes the value of the 'porciones' variable.
     * @param porciones Integer
     */
    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }
    /***
     * This method returns the 'duracion' variable.
     * @return Integer
     */
    public String getDuracion() {
        return duracion;
    }
    /***
     * This method changes the value of the 'duracion' variable.
     * @param duracion String
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    /***
     * This method returns the 'tiempo' variable.
     * @return String
     */
    public String getTiempo() {
        return tiempo;
    }
    /***
     * This method changes the value of the 'tiempo' variable.
     * @param tiempo String
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    /***
     * This method returns the 'dificultad' variable.
     * @return Integer
     */
    public int getDificultad() {
        return dificultad;
    }
    /***
     * This method changes the value of the 'dificultad' variable.
     * @param dificultad Integer
     */
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    /***
     * This method returns the 'dieta' variable.
     * @return Array
     */
    public String[] getDieta() {
        return dieta;
    }
    /***
     * This method changes the value of the 'dieta' variable.
     * @param dieta Array
     */
    public void setDieta(String[] dieta) {
        this.dieta = dieta;
    }
    /***
     * This method returns the 'ingredientes' variable.
     * @return Array
     */
    public String[] getIngredientes() {
        return ingredientes;
    }
    /***
     * This method changes the value of the 'ingredientes' variable.
     * @param ingredientes Array
     */
    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }
    /***
     * This method returns the 'pasos' variable.
     * @return Array
     */
    public String[] getPasos() {
        return pasos;
    }
    /***
     * This method changes the value of the 'pasos' variable.
     * @param pasos Array
     */
    public void setPasos(String[] pasos) {
        this.pasos = pasos;
    }
    /***
     * This method returns the 'calificacion' variable.
     * @return Integer
     */
    public int getCalificacion() {
        return calificacion;
    }
    /***
     * This method changes the value of the 'calificacion' variable.
     * @param calificacion Integer
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    /***
     * This method returns the 'dia' variable.
     * @return Integer
     */
    public int getDia() {
        return dia;
    }
    /***
     * This method changes the value of the 'dia' variable.
     * @param dia Integer
     */
    public void setDia(int dia) {
        this.dia = dia;
    }
    /***
     * This method returns the 'mes' variable.
     * @return Integer
     */
    public int getMes() {
        return mes;
    }
    /***
     * This method changes the value of the 'mes' variable.
     * @param mes Integer
     */
    public void setMes(int mes) {
        this.mes = mes;
    }
}
