package com.company.practice;

import java.util.ArrayList;
import java.util.List;

public class PrintListInReverse {

    public static void main(String[] args){
        MyList list = new MyList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.printList();
        System.out.println();
        printListReverse(list.head);
    }

    public static void printListReverse(Node headNode) {
        if (headNode == null)
            return;
        printListReverse(headNode.next);
        System.out.print(headNode.data + " -> ");
    }

}

