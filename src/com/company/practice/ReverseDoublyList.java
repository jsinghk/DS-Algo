package com.company.practice;

public class ReverseDoublyList {
    public static void main(String[] args){
        DoublyList list = new DoublyList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.print();
        System.out.println();
        list.printReverse();
        System.out.println();

//        DoublyList resLst = reverseList(list);
//        System.out.println("Result : ");
//        resLst.print();
//        System.out.println();
//        resLst.printReverse();

        DoublyList resRecLst = new DoublyList();
        resRecLst.head = reverseRecursive(list.head);
        System.out.println("Result : ");
        resRecLst.print();

    }

    public static DoublyList reverseList(DoublyList lst){
        if(lst.head == null || lst.head.next==null){
            return lst;
        }
        DoublyList.Node prev = null;
        DoublyList.Node curr = lst.head;
        DoublyList.Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        lst.tail = lst.head;
        lst.head = prev;
        return lst;
    }

    public static DoublyList.Node reverseRecursive(DoublyList.Node head){
        if (head.next == null || head == null){
            head.prev = null;
            return head;
        }

        DoublyList.Node node = reverseRecursive(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;
        return node;
    }
}
