package com.company.practice.Array;

public class ArrayMedianOfTwoSortedArrays {

    public static void main(String[] args){
        int[] arr1 = {-5, 3, 6, 12, 15, 17};
        int[] arr2 = {-12, -10, -6, -3, 4, 10};
        System.out.println("Median : " + median(arr1,arr2));
    }

    //Time complexity is O(m+n)
    //Space complexity is O(1)
    public static double median(int[] arr1, int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int i=0,j=0;
        int med1=-1, med2=-1;
        if ((m+n)%2==1){
            for (int count=0;count<=(m+n)/2;count++){
                if (i!=m && j!=n) {
                    med1 = arr1[i] > arr2[j] ? arr2[j++] : arr1[i++];
                }
                if (i==m) {
                    med1 = arr2[j++];
                }
                if (j==n) {
                    med1=arr1[i++];
                }
            }
            return med1;
        } else {
            for (int count=0;count<=(m+n)/2;count++){
                med2 = med1;
                if (i!=m && j!=n) {
                    med1 = arr1[i] > arr2[j] ? arr2[j++] : arr1[i++];
                }
                if (i==m) {
                    med1 = arr2[j++];
                }
                if (j==n) {
                    med1=arr1[i++];
                }
            }
            return (med1+med2)/2.0;
        }
    }
}
