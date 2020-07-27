package com.SortAlgorithms;
/***
 * Radix sorting class.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class RadixSort {
    /***
     * Main method for the RadixSort Class
     * @param arr Array
     */
    public static void radixSort(int[] arr){
        if(arr.length <= 1) return;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while(max / 10 > 0){
            maxDigit++;
            max = max / 10;
        }
        int[][] buckets = new int[10][arr.length];
        int base = 10;
        for(int i = 0; i < maxDigit; i++){
            int[] bktLen = new int[10];
            for(int j = 0; j < arr.length; j++){
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }
            int k = 0;
            for(int b = 0; b < buckets.length; b++){
                for(int p = 0; p < bktLen[b]; p++){
                    arr[k++] = buckets[b][p];
                }
            }
            base *= 10;
        }
    }
}
