package com.company.practice.Array;

import java.util.Arrays;

//Find no. of unique words possible from a given number.
//e.g - 2112 = 5 {BAAB, VAB, BKB, BAL, VL}
public class ArrayWordsFromNumber {
    static int count = 0;
    public static void main(String[] args) {
        int[] num = {2,1,1,2};
        noOfWords(num, 0);
        System.out.println("Total Words : " + count);
    }
    //When no 0 in string
    public static void noOfWords(int[] arr, int st) {
        if (st == arr.length) {
            count++;
            return;
        }
        int sum = 0;
        for (int i = st; i <= Integer.min(st + 1, arr.length - 1); i++)
        {
            sum = (sum * 10) + arr[i];
            if (sum > 0 && sum <= 26) {
                noOfWords(arr, i + 1);
            }
        }
    }

    //When 0 in string. Do no consider 01 as 1
    //e.g - 2101 = 1 {BJA}
}
