package com.company.list;

public class IntegerNode {

    private int value;
    private IntegerNode next;

    public IntegerNode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public IntegerNode getNext() {
        return next;
    }

    public void setNext(IntegerNode node) {
        this.next = node;
    }
}
