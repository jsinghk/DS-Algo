package com.company.practice;

import java.util.*;

public class ArrayMergeSortAndUnmerge {
    public static void main(String[] args){
        int[] testArr = {1, 32, 567, 6, 9, 3, 46, 8};
        int k = 2;

        Map<Integer,String> map = new TreeMap<>();
        for (int i=0; i< testArr.length; i=i+k){
            String temp = "";
            String len = "";
            for (int j=i; j<(i+k); j++){
                String ele = String.valueOf(testArr[j]);
                len = len + ele.length();
                temp = temp + ele;
            }
            map.put(Integer.valueOf(temp), len);
        }
        map.forEach((l,v) -> System.out.println("K: " + l + " - " + "V: " + v));

        List<Integer> reslt = new ArrayList<>();
        for (Map.Entry<Integer,String> entry: map.entrySet()){
            String ele = entry.getKey().toString();
            String len = entry.getValue();
            int j=0;
            for (int i=0;i<len.length();i++){
                int end = Character.getNumericValue(len.charAt(i));
                reslt.add(Integer.valueOf(ele.substring(j,j+end)));
                j=j+end;
            }
        }
        reslt.forEach(item -> System.out.print(item + " "));
    }
}
