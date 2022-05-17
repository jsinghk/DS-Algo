package com.company.practice;

public class ReverseList {

    public static void main(String[] args){
        MyList list = new MyList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.printList();
        System.out.println();
        MyList resLst = reverseList(list);
        resLst.printList();

    }

    public static MyList reverseList(MyList lst){
        Node pre = null;
        Node curr = lst.head;
        Node nxt = null;

        while (curr != null){
            nxt = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nxt;
        }

        lst.head = pre;
        return lst;
    }

    public static Node reverseList(Node head){
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}


