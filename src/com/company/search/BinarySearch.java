package com.company.search;

public class BinarySearch {

    public static String binarySearchArray(int[] arr, int searchValue) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (end + start) / 2;

            if (arr[mid] == searchValue) {
                return "Value Found at Position : " + (mid + 1);
            } else if (arr[mid] < searchValue) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return "Not Found";
    }
}
