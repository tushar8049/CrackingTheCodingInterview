package Chapter02_Linked_List;

import CTCI_Libraries.LinkedListNode;

/**
 * Problem 5: Sum Lists
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 *
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 */

public class Problem_05 {
    public static void main(String[] str){
        LinkedListNode number1 = new LinkedListNode(7);
        LinkedListNode.makeLinkedList(number1, new int[]{9,9,9});
        LinkedListNode number2 = new LinkedListNode(5);
        LinkedListNode.makeLinkedList(number2, new int[]{9,2});
        LinkedListNode.printLinkedList(number1);
        LinkedListNode.printLinkedList(number2);

        LinkedListNode result = addLinkedList_FollowUp(number1, number2);
        LinkedListNode.printLinkedList(result);
    }

    /**
     * My Solution
     */
    public static LinkedListNode addLinkedList(LinkedListNode number1, LinkedListNode number2){

        LinkedListNode result = new LinkedListNode();
        LinkedListNode runner = result;
        int carry = 0;
        while(number1 != null || number2 != null || carry != 0) {
            int val1 = 0, val2 = 0;
            if (number1 != null) {
                val1 = number1.data;
                number1 = number1.next;
            }
            if (number2 != null) {
                val2 = number2.data;
                number2 = number2.next;
            }

            int value = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            LinkedListNode temp = new LinkedListNode(value);
            runner.next = temp;
            runner = runner.next;
        }
        return result.next;
    }
    /**
     * My Solution Follow Up!
     */
    public static LinkedListNode addLinkedList_FollowUp(LinkedListNode number1, LinkedListNode number2){
        number1 = LinkedListNode.reverseLinkedList(number1);
        number2 = LinkedListNode.reverseLinkedList(number2);
        return LinkedListNode.reverseLinkedList(addLinkedList(number1, number2));
    }
}
