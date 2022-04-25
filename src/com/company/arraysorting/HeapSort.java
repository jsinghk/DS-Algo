package com.company.arraysorting;

import com.company.heap.Heap;

public class HeapSort {

    public void heapSortArray(Heap testHeap) {
        int lastIndex = testHeap.size -1;
        for (int i=0; i<lastIndex; i++){
            int temp = testHeap.heap[lastIndex-i];
            testHeap.heap[lastIndex-i] = testHeap.heap[0];
            testHeap.heap[0] = temp;

            testHeap.fixHeapBelow(0,lastIndex-1-i);
        }
    }
}
