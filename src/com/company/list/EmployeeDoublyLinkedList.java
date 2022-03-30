package com.company.list;

public class EmployeeDoublyLinkedList {

    private EmployeeDoublyNode tail;
    private EmployeeDoublyNode head;

    public void addToFront(Employee employee){
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee);
        if (head !=null) {
            head.setPrevious(node);
            node.setNext(head);
        }
        else {
            tail = node;
        }

        head=node;
    }

    public boolean addBefore(Employee employee,Employee employeeBefore){

        if (head == null){
            return false;
        }

        EmployeeDoublyNode current = head;
        while (current!=null && !current.getEmployee().equals(employeeBefore)){
            current = (EmployeeDoublyNode) current.getNext();
        }
        if (current == null){
            return false;
        }
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee);
        node.setNext(current);
        node.setPrevious(current.getPrevious());
        current.setPrevious(node);
        if (head == current){
            head =node;
        }
        else {
            node.getPrevious().setNext(node);
        }
        return true;
    }

    public void addToBack(Employee employee){
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee);
        if (tail!=null) {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        else {
            head = node;
        }
        tail=node;
    }

    public void printList(){
        EmployeeDoublyNode current = head;
        System.out.print("HEAD <=> ");
        while (current != null){
            System.out.print(current.getEmployee().toString());
            System.out.print(" <=> ");
            current = (EmployeeDoublyNode) current.getNext();
        }
        System.out.print("null");
    }

    public EmployeeDoublyNode removeFromFront(){
        if ( head == null){
            return null;
        }

        EmployeeDoublyNode removeNode = head;
        head = (EmployeeDoublyNode) head.getNext();
        if (head.getNext() == null){
            tail = null;
        }
        else {
            head.setPrevious(null);
        }

        removeNode.setNext(null);
        return removeNode;
    }

    public EmployeeDoublyNode removeFromBack(){
        if ( tail == null){
            return null;
        }

        EmployeeDoublyNode removeNode = tail;
        tail = tail.getPrevious();
        if (tail.getPrevious() == null){
            head = null;
        }
        else {
            tail.setNext(null);
        }

        removeNode.setPrevious(null);
        return removeNode;
    }
}
