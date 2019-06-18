package Chapter02_Linked_List;

import CTCI_Libraries.LinkedListNode;

import java.util.HashSet;

/**
 * Problem 1: Remove Dups
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?
 */

public class Problem_01 {
    public static void main(String[] arg){
        LinkedListNode head = new LinkedListNode(5);
        LinkedListNode.makeLinkedList(head, new int[]{1,2,2,2,3,3,4});
        LinkedListNode.printLinkedList(head);
        removeDumps_1(head);
        LinkedListNode.printLinkedList(head);
    }

    /**
     * My Solution!
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static void removeDumps_0(LinkedListNode node){
        LinkedListNode head = node;
        LinkedListNode previous = node;
        HashSet<Integer> set = new HashSet<>();

        while(node != null){
            if( set.contains(node.data) ){
                previous.next = node.next;
            }
            else{
                set.add(node.data);
                previous = node;
            }
            node = node.next;
        }
    }

    /**
     *  Looked Up Solution!
     *  Time Complexity: O(n^2)
     *  Space Complexity: O(1)
     */
    public static void removeDumps_1(LinkedListNode node){
        if(node == null)
            return;
        LinkedListNode current = node;
        LinkedListNode runner;
        LinkedListNode previous;

        while(current != null){
            previous = current;
            runner = current.next;
            while(runner != null){
                if(runner.data == current.data){
                    previous.next = runner.next;
                }
                else{
                    previous = runner;
                }
                runner = runner.next;
            }
            current = current.next;
        }
    }
}
