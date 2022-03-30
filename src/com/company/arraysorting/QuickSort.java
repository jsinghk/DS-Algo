package com.company.arraysorting;

public class QuickSort {

    public static void quickSortArray(int[] arr, int start, int end){
        if (end-start < 2){
            return;
        }
        int pivotIndex = partition(arr,start,end);
        quickSortArray(arr,start,pivotIndex);
        quickSortArray(arr,pivotIndex+1,end);
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j){
            while (i<j && arr[--j]>=pivot);
            if (i<j){
                arr[i] = arr[j];
            }
            while (i<j && arr[++i]<=pivot);
            if (i<j){
                arr[j] = arr[i];
            }
        }

        arr[j] = pivot;
        return j;
    }
}
