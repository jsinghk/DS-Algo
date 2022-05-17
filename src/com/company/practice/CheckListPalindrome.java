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
        //System.out.println("List is Palindrome : " + isPalindromeSinglyList(myList, myList.head));
        System.out.println("List is Palindrome : " + isPalindromeSinglyList(myList.head));

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

    //Inplace Algo
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

    //Uses Recursive stack space
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

    //Inplace with Auxiliary Space - O(1)
    private static boolean isPalindromeSinglyList(Node head){
        Node slow = head;
        Node fast = head;
        Node sprev = null;

        while (fast!=null && fast.next!=null){
            sprev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //When list contains odd items
        if (fast != null){
            slow = slow.next;
        }

        sprev.next = null;
        Node list1Head = head;
        Node list2Head = ReverseList.reverseList(slow);

        while (list1Head != null){
            if (list1Head.data != list2Head.data){
                return false;
            }
            list1Head = list1Head.next;
            list2Head = list2Head.next;
        }

        return true;
    }

}
