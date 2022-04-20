package com.company.practice;

class MyList {
    Node head;
    Node tail;

    void add(int data) {
        Node current = new Node();
        current.data = data;
        if (head == null) {
            head = current;
        } else {
            tail.next = current;
        }
        tail = current;
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("NULL");
    }
}
