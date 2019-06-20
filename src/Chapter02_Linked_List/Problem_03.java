package Chapter02_Linked_List;

import CTCI_Libraries.LinkedListNode;

/**
 * Problem 3: Delete Middle Node
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
 * not necessarily the exact middle) of a singly linked list, given only access to that node.
 * EXAMPLE
 * lnput:the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 */

public class Problem_03 {
    public static void main(String[] arg){
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode.makeLinkedList(head, new int[]{1,2,3,4,5,6});
        LinkedListNode.printLinkedList(head);

        deleteElementFromMiddle_0(head, 4);

        LinkedListNode.printLinkedList(head);

    }

    /**
     * My Solution!
     */
    public static void deleteElementFromMiddle_0(LinkedListNode head, int ele){
        LinkedListNode current = head;
        LinkedListNode previous = head;
        while(current != null){
            if(current.data == ele)
                break;
            previous = current;
            current = current.next;
        }
        if(current == null){
            System.out.println("Element not found!");
        }
        else if(current.data == ele){
            previous.next = current.next;
        }
    }
}
