package Chapter02_Linked_List;

import CTCI_Libraries.LinkedListNode;

/**
 * Problem 6: Palindrome
 * Implement a function to check if a linked list is a palindrome.
 */

public class Problem_06 {
    public static void main(String[] args){
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode.makeLinkedList(head, new int[]{1,2,3,1,0});
        LinkedListNode.printLinkedList(head);

        boolean status = linkedListIsPalindrome(head);
        System.out.println("\n Is LinkedList a Palindrome? " + status);
    }

    /**
     * My Solution!
     */
    public static boolean linkedListIsPalindrome(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode second = LinkedListNode.reverseLinkedList(slow.next);
        LinkedListNode first = head;

        while(first != null && second != null){
            if(first.data != second.data)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
}
