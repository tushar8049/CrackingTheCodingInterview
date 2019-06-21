package Chapter02_Linked_List;

import CTCI_Libraries.LinkedListNode;

/**
 * Problem 7: Intersection
 * Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 */

public class Problem_07 {
    public static void main(String[] arg){
        int[] vals1 = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] vals2 = {12, 14, 15};

        LinkedListNode list1 = new LinkedListNode();
        LinkedListNode list2 = new LinkedListNode();
        LinkedListNode.makeLinkedList(list1, vals1);
        LinkedListNode.makeLinkedList(list2, vals2);
        list1=list1.next;
        list2=list2.next;

        // Original LinkedList
        LinkedListNode.printLinkedList(list1);
        LinkedListNode.printLinkedList(list2);

        //Intersected LinkedList
        list2.next.next.next = list1.next.next.next.next.next;

        LinkedListNode.printLinkedList(list1);
        LinkedListNode.printLinkedList(list2);
        if(intersectionNode(list1, list2) != null)
            System.out.println("\n The intersecting node is "+intersectionNode(list1, list2).data);

    }

    /**
     * My Solution!
     */
    public static LinkedListNode intersectionNode(LinkedListNode list1, LinkedListNode list2){

        // Check if the last node for both the list have the same ending.
        if(LinkedListNode.getLastNode(list1) != LinkedListNode.getLastNode(list2)){
            return null;
        }

        // Decide which list is longer and shorter.
        LinkedListNode longer = LinkedListNode.length(list1) >= LinkedListNode.length(list2) ? list1 : list2;
        LinkedListNode shorter = LinkedListNode.length(list1) < LinkedListNode.length(list2) ? list1 : list2;


        int difference = Math.abs(LinkedListNode.length(list1) - LinkedListNode.length(list2));

        // Move the beginning of the longer list to catch up with the difference count.
        for(int i = 0; i < difference; i++){
            longer = longer.next;
        }

        // Move both the shorter and the longer node simultaneously until they get to the same.
        while(shorter != longer){
            longer = longer.next;
            shorter = shorter.next;
        }

        // Return either the longer or the shorter list.
        return shorter;
    }

}
