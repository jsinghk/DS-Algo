package com.company.list;

public class IntegerLinkedList {

    private IntegerNode head;

    public void addSorted(int value){
        IntegerNode node = new IntegerNode(value);

        if (head == null || head.getValue() >= value){
            node.setNext(head);
            head = node;
            return;
        }

        IntegerNode current = head.getNext();
        IntegerNode previous = head;

        while (current!=null && current.getValue()<value){
            previous =current;
            current =current.getNext();
        }
        node.setNext(current);
        previous.setNext(node);

    }

    public void printList(){
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current!=null){
            System.out.print(current.getValue());
            System.out.print(" -> ");
            current =current.getNext();
        }
        System.out.print("null");
    }
}
