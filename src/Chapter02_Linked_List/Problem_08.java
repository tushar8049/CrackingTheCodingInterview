package Chapter02_Linked_List;


import CTCI_Libraries.LinkedListNode;

/**
 * Problem 8: Loop Detection
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
 * so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 */

public class Problem_08 {
    public static void main(String[] arg){
        int[] vals1 = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};

        LinkedListNode list1 = new LinkedListNode();
        LinkedListNode.makeLinkedList(list1, vals1);
        list1=list1.next;

        // Original LinkedList
        LinkedListNode.printLinkedList(list1);

        // Making List Circular
        LinkedListNode runner = list1;
        LinkedListNode temp = null;
        int counter = 0;
        while( counter < 7){

            if( counter == 2)
                temp = runner.next;

            if(counter == 6)
                runner.next = temp;

            runner = runner.next;
            counter++;
        }

        System.out.println("\n This is the circular LinkedList");
        runner = list1;
        for(int i = 0; i < 15; i++){
            System.out.print(" -> " + runner.data);
            runner = runner.next;
        }


        System.out.println("\n Loop Detected in the LinkedList: "+isLinkedListLoop(list1));

        // NonLoop LinkedList
        LinkedListNode nonLoop = new LinkedListNode();
        LinkedListNode.makeLinkedList(nonLoop, vals1);
        nonLoop=nonLoop.next;

        LinkedListNode.printLinkedList(nonLoop);
        System.out.println("\n Loop Detected in the LinkedList: "+isLinkedListLoop(nonLoop));

    }
    /**
     * My Solution!
     */
    public static boolean isLinkedListLoop(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // At some point the Slow pointer and the fast pointer would become same
        // and that is when we realize that there is a loop in the LinkedList.
        do{
            slow = slow.next;
            fast = fast.next.next;
        } while(slow != fast && fast.next != null && fast.next.next != null);

        // If the breaking condition for the loop is because the fast pointer became null
        // then the LinkedList doesn't have a Loop so return False.
        if(fast.next == null || fast.next.next == null)
            return false;
        return true;
    }
}
