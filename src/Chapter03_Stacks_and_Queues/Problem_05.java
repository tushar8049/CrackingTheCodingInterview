package Chapter03_Stacks_and_Queues;

import CTCI_Libraries.AssortedMethods;
import java.util.Stack;

/**
 * Problem 5: Sort Stack
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements
 * into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and is Empty.
 */

public class Problem_05 {
    public static void main(String[] arg){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(6);
        sort(stack);

        System.out.println("Sorted Stack:");
        AssortedMethods.printStack(stack);
    }

    /**
     *
     */
    public static void sort(Stack<Integer> stack){

        Stack<Integer> temp = new Stack<>();

        while(!stack.isEmpty()){
            int value = stack.pop();
            while(!temp.isEmpty() && value < temp.peek()){
                stack.push(temp.pop());
            }
            temp.push(value);
        }

        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }
}
