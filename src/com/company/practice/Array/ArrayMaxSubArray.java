package com.company.practice.Array;

public class ArrayMaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,1,-2,-1,5,2,-3};
        int max = arr[0];
        int sum = 0;
        for (int i=0;i<arr.length; i++){
            sum = sum + arr[i];
            if (max < sum ) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("MaxSum : " + max);
    }
}