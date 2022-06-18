package com.company.practice;

import java.util.Arrays;

//Find the no. of ways you can equal the totalScore. Each turn score possible - 6,4,2
public class ArrayBookCricket {
    public static void main(String[] args) {
        int totalScore = 12;
        System.out.println("Total Ways : " + noOfWays(totalScore));
        System.out.println("Total Ways No Perm: " + noOfWaysNoPerm(totalScore));
    }

    //Permutation allowed for a way
    public static int noOfWays(int totalScore) {
        if (totalScore<0){
            return 0;
        }
        if (totalScore==0){
            return 1;
        }
        int ways = 0;
        ways += noOfWays(totalScore-6);
        ways += noOfWays(totalScore-4);
        ways += noOfWays(totalScore-2);
        return ways;
    }

    //Permutation not allowed for a way
    public static int noOfWaysNoPerm(int totalScore) {
        int[] table = new int[totalScore+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i=2; i<=totalScore; i++) {
            table[i] += table[i-2];
        }
        for (int i=4; i<=totalScore; i++) {
            table[i] += table[i-4];
        }
        for (int i=6; i<=totalScore; i++) {
            table[i] += table[i-6];
        }
        return table[totalScore];
    }
}
