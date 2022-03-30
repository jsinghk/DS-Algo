package com.company.arraysorting;

public class SelectionSort {
    public static int[] selectionSortArray(int[] arr){
        for (int unsortedIndex=arr.length-1; unsortedIndex>0; unsortedIndex--){
            int largest = 0;
            for (int i=1; i<=unsortedIndex; i++){
                if (arr[largest] < arr[i]){
                    largest = i;
                }
            }
            swap(arr,largest,unsortedIndex);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j){
        if ( i == j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
