package com.SortAlgorithms;

/***
 * Quick sorting class.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class QuickSort {

    /***
     * Main method for the QuickSort Class
     * @param arr Array
     * @param low Integer
     * @param high Integer
     */
    public static void quickSort(int[] arr, int low, int high){
        if(arr.length <= 0) return;
        if(low >= high) return;
        int left = low;
        int right = high;

        int temp = arr[left];
        while (left < right){
            while(left < right && arr[right] >= temp){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        quickSort(arr, low, left-1);
        quickSort(arr, left+1, high);
    }
}
