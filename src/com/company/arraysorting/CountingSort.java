package com.company.arraysorting;

public class CountingSort {

    public static void countingSortArray(int[] arr, int min, int max){

        int[] countArr = new int[max-min+1];

        for (int i=0; i<arr.length; i++){
            countArr[arr[i] - min]++;
        }

        int j=0;
        for (int i=min;i<=max;i++){
            while (countArr[i-min]>0){
                arr[j++] = i;
                countArr[i-min]--;
            }
        }
    }
}
