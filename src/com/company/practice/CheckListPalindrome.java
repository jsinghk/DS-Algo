package com.company.practice;

public class CheckListPalindrome {

    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(3);
        myList.add(2);
        myList.add(1);

        myList.printList();
        System.out.println();
        System.out.println("List is Palindrome : " + isPalindromeSinglyList(myList, myList.head));

        DoublyList list = new DoublyList();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        list.add(5);

//        list.print();
//        System.out.println();
//        System.out.println("List is Palindrome : " + isPalindromeDoublyList(list));

    }

    private static boolean isPalindromeDoublyList(DoublyList list){
        DoublyList.Node head = list.head;
        DoublyList.Node tail = list.tail;
        while (head != null){
            if (head.data != tail.data){
                return false;
            }
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }

    private static boolean isPalindromeSinglyList(MyList list, Node right){
        if (right == null){
            return true;
        }

        boolean res = isPalindromeSinglyList(list, right.next);
        if (!res){
            return res;
        }

        Node left = list.head;
        System.out.println(left.data + " - " + right.data);
        if (left.data != right.data){
            res = false;
        }

        list.head = list.head.next;
        return res;
    }

}
