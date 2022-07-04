package com.company.practice.Array;

public class ArrayWaterBucket {

    public static void main(String[] args){
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 0, 2, 1, 2, 1};
        System.out.println("Water vol : " + calculateWaterVol(arr));
    }

    //Time complexity is O(n)
    //Space complexity is O(1)
    public static int calculateWaterVol(int[] arr) {
        int vol = 0;
        int lmax=0, rmax=0;
        int l=0,r=arr.length-1;
        while (l<r){
            if (arr[l] < arr[r]) {
                if (arr[l] > lmax) {
                    lmax = arr[l];
                } else {
                    vol = vol + lmax - arr[l];
                }
                l++;
            } else {
                if (arr[r] > rmax) {
                    rmax = arr[r];
                } else {
                    vol = vol + rmax - arr[r];
                }
                r--;
            }
        }
        return vol;
    }
}
