package com.company.practice;

public class MergeListSorted {

    public static void main(String[] args){
        MyList list1 = new MyList();
        list1.add(1);
        list1.add(3);
        list1.add(6);

        MyList list2 = new MyList();
        list2.add(2);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list1.printList();
        System.out.println();
        list2.printList();
        System.out.println();

        MyList resLst = mergeListSorted(list1.head ,list2.head);
        resLst.printList();

    }

    public static MyList mergeListSorted(Node head1, Node head2){
        MyList resLst = new MyList();
        while (head1 != null){
            if (head2 != null){
                if (head1.data < head2.data){
                    resLst.add(head1.data);
                    head1 = head1.next;
                } else {
                    resLst.add(head2.data);
                    head2 = head2.next;
                }
            } else {
                resLst.add(head1.data);
                head1 = head1.next;
            }
        }

        while (head2 != null){
            resLst.add(head2.data);
            head2 = head2.next;
        }

        return resLst;
    }

}
