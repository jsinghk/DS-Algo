package com.company.arraysorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void bucketSortArray(int[] arr){

        List<Integer>[] bucket = new List[10];

        for (int i=0; i<10; i++){
            bucket[i] = new ArrayList<>();
        }

        for (int num : arr){
            bucket[hash(num)].add(num);
        }

        for (List list : bucket){
            Collections.sort(list);
        }

        int j=0;
        for (int i=0; i<10; i++){
            for (int num : bucket[i]){
                arr[j++] = num;
            }
        }
    }

    private static int hash(int key){
        return key/10;
    }
}
