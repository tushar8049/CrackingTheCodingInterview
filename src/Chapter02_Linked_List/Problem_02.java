package Chapter02_Linked_List;

import CTCI_Libraries.LinkedListNode;

public class Problem_02 {
    public static void main(String[] arg){
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode.makeRandomLinkedList(head, 5, 0,9);
        LinkedListNode.printLinkedList(head);
        int k = 3;

        System.out.println("\n " + k + "th element from the end is " + kthToLast_1(head, k));

        head = kthToLast_0(head, k);
        if(head != null)
            LinkedListNode.printLinkedList(head);
        else
            System.out.println("\n K out of range");


    }

    /**
     * My Solution!
     */
    public static LinkedListNode kthToLast_0(LinkedListNode node, int k){
        int i = 1;
        LinkedListNode runner = node;
        while(i <= k && runner != null){
            if(i != k){
                runner = runner.next;
            }
            i++;
        }
        if(runner == null){
            return null;
        }
        node = runner;
        return node;
    }

    /**
     * My Solution!
     */
    public static int kthToLast_1(LinkedListNode node, int k){

        LinkedListNode runner1 = node;
        LinkedListNode runner2 = node;

        int i = 1;
        // Traverse upto the kth Element or until the node becomes null
        while(i <= k && runner1 != null){
            runner1 = runner1.next;
            i++;
        }

        if(runner1 == null)
            return -1;

        // Move both the pointers simultaneously until the first runner hits the end.
        while(runner1 != null){
            runner2 = runner2.next;
            runner1 = runner1.next;
        }
        // After the first runner hits the end, Second runner points to the kth element from the end.
        return runner2.data;
    }

}
