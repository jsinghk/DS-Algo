package com.company.practice;

public class DoublyList {
    Node head;
    Node tail;

    public void add(int data){
        Node node = new Node();
        node.data = data;
        if (head == null){
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    public void print(){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.print("NULL");
    }

    public void printReverse(){
        Node curr = tail;
        while (curr != null){
            System.out.print(curr.data + " <-> ");
            curr = curr.prev;
        }
        System.out.print("NULL");
    }

    class Node{
        Node next;
        Node prev;
        int data;
    }
}
