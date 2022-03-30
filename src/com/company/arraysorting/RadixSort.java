package com.company.arraysorting;

public class RadixSort {

    public static void radixSortArray(int[] arr, int radix, int width){

        for (int i=0;i<width;i++){
            singleSort(arr,radix,i);
        }
    }

    public static void singleSort(int[] arr, int radix, int pos){

        int numItems = arr.length;
        int[] countArr = new int[radix];
        for (int value : arr){
            countArr[getDigit(pos,value,radix)]++;
        }

        for(int j=1; j<radix; j++){
            countArr[j] = countArr[j] + countArr[j-1];
        }

        int[] temp = new int[numItems];
        for (int k=numItems-1;k>=0;k--){
            temp[--countArr[getDigit(pos, arr[k], radix)]] = arr[k];
        }

        System.arraycopy(temp,0,arr,0,numItems);

    }

    public static int getDigit(int pos, int value, int radix){
        return value/(int) Math.pow(radix,pos) % radix;
    }
}
