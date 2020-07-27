package com.SortAlgorithms;

import com.ListaEnlazada.ListaEnlazada;
import com.RecetasManager.Receta;

import java.util.Arrays;
/***
 * Insertion sorting class.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class InsertionSort {
    /***
     * Method that convert the array in date elements
     * @param arr Array
     */
    public static ListaEnlazada<String[]> covertToDate(Receta[] arr){
        int dateReceta[] =new int[arr.length];
        for(int i = 0; i< arr.length;i++){
            dateReceta[i] = arr[i].getDia();


        }
        ListaEnlazada<String[]> lista = new ListaEnlazada<String[]>();
        int[] ordenado = insertionSort(dateReceta);
        for(int i = 0; i<arr.length;i++){
            int pos = 0;
            while(ordenado[i] != arr[pos].getDia()){
                pos++;
            }
            String[] temp = new String[2];
            temp[0] = arr[pos].getAutor();
            temp[1] = arr[pos].getName();
            lista.add(temp);
        }
        return lista;

    }
    /***
     * Main method for the InsertionSort Class
     * @param arr Array
     */
    public static int[] insertionSort(int[] arr){
        for( int i=0; i<arr.length-1; i++ ) {
            for( int j=i+1; j>0; j-- ) {
                if( arr[j-1] <= arr[j] )
                    break;
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                System.out.println("Sorting:  " + Arrays.toString(arr));

            }
        }return arr;
    }
}
