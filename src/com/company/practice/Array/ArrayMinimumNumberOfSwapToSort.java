package com.company.practice.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayMinimumNumberOfSwapToSort {

    public static void main(String[] args) {
        int[] testArr= {101, 758, 315, 730, 472, 619, 460, 479};
        minSwap(testArr);
    }

    public static void minSwap(int[] testArr) {
        Map<Integer, Integer> indMap = new HashMap<>();
        int[] temp = Arrays.copyOf(testArr, testArr.length);
        Arrays.sort(temp);
        for (int i=0; i<testArr.length; i++) {
            indMap.put(testArr[i], i);
        }

        int count = 0;
        for (int j=0; j<testArr.length; j++) {
            if (testArr[j] != temp[j]) {
                count++;
                int index = indMap.get(temp[j]);
                int tem = testArr[j];
                testArr[j] = testArr[index];
                testArr[index] = tem;

                indMap.put(testArr[j], j);
                indMap.put(tem, index);
            }
        }
        System.out.println("Min no. of swaps : " + count);
    }
}
