package com.company.arraysorting;

public class ShellSort {

    //Choosing Gap value = arr-length/2
    public static int[] shellSortArray(int[] arr){
        for (int gap=arr.length/2; gap>0;gap=gap/2){

            for (int i = gap; i< arr.length; i++){
                int newElement = arr[i];
                int j = i;
                while (j>=gap && arr[j-gap]>newElement){
                    arr[j] = arr[j-gap];
                    j = j-gap;
                }
                arr[j] = newElement;
            }
        }

        return arr;
    }
}
