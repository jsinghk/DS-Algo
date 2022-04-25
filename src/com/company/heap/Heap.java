package com.company.heap;

public class Heap {
    public int[] heap;
    public int size;

    public Heap(int size){
        heap = new int[size];
    }

    public void insert(int data) {
        if (isFull()){
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = data;
        fixHeapAbove(size);
        size++;
    }

    public int delete(int index) {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Heap is Empty");
        }
        int parent = heap[getParent(index)];
        int deletedValue = heap[index];
        heap[index] = heap[size-1];

        if (index == 0 || heap[index] < parent){
            fixHeapBelow(index, size-1);
        } else {
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    public void printHeap() {
        for (int i=0; i<size; i++){
            System.out.print(heap[i] + " , ");
        }
        System.out.println();
    }

    public void fixHeapAbove(int index) {
        int data = heap[index];
        while (index>0 && data>heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = data;
    }

    public void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwapIndex;
        while (index <= lastHeapIndex){
            int leftChildIndex = getChild(index, true);
            int rightChildIndex = getChild(index, false);
            if (leftChildIndex <= lastHeapIndex){
                if (rightChildIndex <= lastHeapIndex){
                    childToSwapIndex = (heap[leftChildIndex] > heap[rightChildIndex] ?
                            leftChildIndex : rightChildIndex);
                } else {
                    childToSwapIndex = leftChildIndex;
                }

                if (heap[index] < heap[childToSwapIndex]){
                    int temp = heap[index];
                    heap[index] = heap[childToSwapIndex];
                    heap[childToSwapIndex] = temp;
                } else {
                    break;
                }
                index = childToSwapIndex;

            } else {
                break;
            }
        }
    }

    private boolean isFull(){
        return size == heap.length;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private int getParent(int index){
        return (index - 1)/2;
    }

    private int getChild(int index, boolean left) {
        return 2*index + (left ? 1 : 2);
    }
}
