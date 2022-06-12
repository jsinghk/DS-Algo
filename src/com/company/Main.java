package com.company;


import com.company.arraysorting.*;
import com.company.hashtable.ArrayHashTable;
import com.company.hashtable.ChainedHashTable;
import com.company.heap.Heap;
import com.company.list.Employee;
import com.company.list.IntegerLinkedList;
import com.company.queue.ArrayQueue;
import com.company.search.BinarySearch;
import com.company.stack.ListStack;
import com.company.tree.Tree;

import java.util.Set;


public class Main {

    public static void main(String[] args) {
        treeImplementation();
    }

    private static void arraySort() {
//        int[] arr = {10,34,-22,56,-44,5,0,75};
//        int[] arr1 = {10,2,2,4,5,9,7,8,8};
//        int[] arr2 = {4725,4586,1330,8729,1594,5729};
//        int[] arr3 = {56, 64, 83, 45, 95, 93, 42};
//        int[] result = BubbleSort.bubbleSortArray(arr);
//        int[] result1 = SelectionSort.selectionSortArray(arr);
//        int[] result2 = InsertionSort.insertionSortArray(arr);
//        int[] result3 = ShellSort.shellSortArray(arr);
//        MergeSort.mergeSortArray(arr,0, arr.length);
//        QuickSort.quickSortArray(arr,0,arr.length);
//        CountingSort.countingSortArray(arr1,1,10);
//        RadixSort.radixSortArray(arr2,10,4);
//        BucketSort.bucketSortArray(arr3);
//
//        for (int i : arr3) {
//            System.out.print(" " + i);
//        }
    }

    private static void binarySearch() {
        int[] sortedArr = {-22, -15, 1, 7, 20, 35, 55};
        int searchValue = 1;
        String res = BinarySearch.binarySearchArray(sortedArr, searchValue);
        System.out.println(res);
    }

    private static void listImplementation() {
        Employee employee1 = new Employee("Jane", 1001);
        Employee employee2 = new Employee("Mike", 1002);
        Employee employee3 = new Employee("John", 1003);
        Employee employee4 = new Employee("Dane", 1004);
        Employee employee5 = new Employee("Bailey", 1005);

//        EmployeeLinkedList emloyeeList = new EmployeeLinkedList();
//        emloyeeList.addToFront(employee1);
//        emloyeeList.addToFront(employee2);
//        emloyeeList.addToFront(employee3);
//        emloyeeList.addToFront(employee4);

//        EmployeeDoublyLinkedList doublyEmployeeList = new EmployeeDoublyLinkedList();
//        doublyEmployeeList.addToFront(employee1);
//        doublyEmployeeList.addToFront(employee2);
//        doublyEmployeeList.addToBack(employee4);
//        doublyEmployeeList.addToBack(employee3);
//
//        //doublyEmployeeList.printList();
//
//        doublyEmployeeList.removeFromFront();
//        doublyEmployeeList.addBefore(employee5,employee3);
//        doublyEmployeeList.printList();

        IntegerLinkedList list = new IntegerLinkedList();
        list.addSorted(4);
        list.addSorted(2);
        list.addSorted(1);
        list.addSorted(3);

        list.printList();
    }

    private static void stackImplementation() {

        Employee employee1 = new Employee("Jane", 1001);
        Employee employee2 = new Employee("Mike", 1002);
        Employee employee3 = new Employee("John", 1003);
        Employee employee4 = new Employee("Dane", 1004);
        Employee employee5 = new Employee("Bailey", 1005);

        //ArrayStack stack = new ArrayStack(4);
        ListStack stack = new ListStack();
        stack.push(employee1);
        stack.push(employee2);
        stack.push(employee3);
        stack.push(employee4);
        stack.push(employee5);

        stack.printStack();
        System.out.println("Pop : " + stack.pop());
        System.out.println("Peek : " + stack.peek());
        stack.printStack();
    }

    private static void queueImplementation() {
        Employee employee1 = new Employee("Jane", 1001);
        Employee employee2 = new Employee("Mike", 1002);
        Employee employee3 = new Employee("John", 1003);
        Employee employee4 = new Employee("Dane", 1004);
        Employee employee5 = new Employee("Bailey", 1005);

        ArrayQueue queue = new ArrayQueue(4);
        queue.add(employee1);
        queue.add(employee2);
        queue.add(employee3);
        queue.add(employee4);
        queue.add(employee5);

        queue.printQueue();
        System.out.println("Removed : " + queue.remove());

    }

    private static void hashtableImplementation() {
        Employee employee1 = new Employee("Jane", 1001);
        Employee employee2 = new Employee("Mike", 1002);
        Employee employee3 = new Employee("John", 1003);
        Employee employee4 = new Employee("James", 1012);

        //ArrayHashTable hashTable = new ArrayHashTable();
        ChainedHashTable hashTable = new ChainedHashTable();
        hashTable.put(employee1);
        hashTable.put(employee2);
        hashTable.put(employee3);
        hashTable.put(employee4);

        hashTable.printHashTable();
        System.out.println(hashTable.get(1002));
        System.out.println(hashTable.get(1012));

        hashTable.remove(1002);
        hashTable.printHashTable();
        System.out.println(hashTable.get(1012));
    }

    private static void treeImplementation(){
        Tree binaryTree = new Tree();
        binaryTree.insert(25);
        binaryTree.insert(20);
        binaryTree.insert(27);
        binaryTree.insert(15);
        binaryTree.insert(30);
        binaryTree.insert(32);
        binaryTree.insert(22);
        binaryTree.insert(29);
        binaryTree.insert(26);
        binaryTree.insert(17);
        binaryTree.insert(21);

        System.out.println(binaryTree.getDiameterOfTree());
        //binaryTree.traverseInorder();
        //binaryTree.traverseLevelOrder();
        //binaryTree.traverseZigZag();
        System.out.println();
        //binaryTree.getAllLeafNodesAndSumWhichAreLeftChild();
//        System.out.println();
//        System.out.println(binaryTree.get(27));
//
//        System.out.println(binaryTree.min());
//        System.out.println(binaryTree.max());
//
//        binaryTree.delete(15);
//        binaryTree.traverseInorder();
//        System.out.println();
//
//        binaryTree.delete(25);
//        binaryTree.traverseInorder();
//        System.out.println();
//        System.out.println(binaryTree.getRootNode().getData());
        //System.out.println(binaryTree.getHeightOfTree());

    }

    private static void heapImplementation() {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();
//        int deletedValue = heap.delete(5);
//        System.out.println("Deleted Value : " + deletedValue);
//        heap.printHeap();
        new HeapSort().heapSortArray(heap);
        heap.printHeap();
    }
}
