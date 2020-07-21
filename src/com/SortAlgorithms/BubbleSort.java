package com.SortAlgorithms;

/***
 * Bubble sorting class.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class BubbleSort {

    /***
     * Main method for the BubbleSort Class
     * @param arr Array
     */
    public static void bubbleSort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
