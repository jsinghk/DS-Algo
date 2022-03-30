package com.company.arraysorting;

public class BubbleSort {

    public static int[] bubbleSortArray(int[] arr){
        for (int unsortedIndex=arr.length-1; unsortedIndex>0; unsortedIndex--){
            for (int i=0; i<unsortedIndex; i++){
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
