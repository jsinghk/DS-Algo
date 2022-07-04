package com.company.practice.Array;

import java.util.ArrayList;
import java.util.List;

public class ArrayRotate {
    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        int d=-2; //-ve for left rotation

        List<Integer> res = rotate(arr,d);
        //arr.subList(0,1).forEach(num -> System.out.print(" " + num)); //For subarray rotation
        System.out.println("Result :");
        res.forEach(num -> System.out.print(" " + num));
    }

    public static List<Integer> rotate(List<Integer> arr,int d){
        int len = arr.size();
        int dist = d % len;
        System.out.println(" d : " + dist);

        List<Integer> res = new ArrayList<>();
        res.addAll(arr);
        for (int i=0;i<len;i++){
            res.set(i,arr.get((len-dist+i)%len));
        }
        return res;
    }
}
