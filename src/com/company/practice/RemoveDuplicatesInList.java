package com.company.practice;

public class RemoveDuplicatesInList {

    public static void main(String[] args){
        MyList list = new MyList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);

        list.printList();
        System.out.println();
        removeDuplicates(list.head);
        list.printList();
    }

    public static void removeDuplicates(Node head) {
        if(head == null){
            return;
        }

        int value = head.data;
        Node pre = head;
        Node curr = head.next;
        while (curr != null){
            if (curr.data == value){
                pre.next = curr.next;
            } else {
                value = curr.data;
                pre = pre.next;
            }
            curr = curr.next;
        }
    }

}
