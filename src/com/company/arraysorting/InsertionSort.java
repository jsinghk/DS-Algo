package com.company.arraysorting;

public class InsertionSort {
    public static int[] insertionSortArray(int[] arr){

        for (int unsortedIndex= 1; unsortedIndex < arr.length; unsortedIndex++){
            int newUnsortedElement = arr[unsortedIndex];

            int i;
            for (i = unsortedIndex;i>0 && arr[i-1]>newUnsortedElement ; i--){
                arr[i] = arr[i-1];
            }
            arr[i] = newUnsortedElement;
        }
        return arr;
    }

}
