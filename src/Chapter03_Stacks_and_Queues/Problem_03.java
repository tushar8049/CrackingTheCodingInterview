package Chapter03_Stacks_and_Queues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Stack of Plates:
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be composed of several stacks
 * and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
 * (that is, pop () should return the same values as it would if there were just a single stack).
 *
 * FOLLOW UP
 * Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack.
 */

public class Problem_03 {

    public static void main(String[] arg){
        SetOfStacks setOfStacks = new SetOfStacks(3);

        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);
        System.out.println(setOfStacks.popAt(5));
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.popAt(0));
        System.out.println(setOfStacks.popAt(0));
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());

        setOfStacks.push(8);
        System.out.println(setOfStacks.pop());
    }

    /**
     *
     */
    public static class SetOfStacks{
        private ArrayList<Stack<Integer>> stacks;   //ArrayList of Stacks
        private ArrayList<Integer> stackCount;      //ArrayList keeping a count of elements in each Stack
        private int totalStacks;                    //Total Number of Stacks
        private int threshold;                      //Threshold of each Stack (Common for all)

        // Constructor
        public SetOfStacks( int threshold){
            stacks = new ArrayList<>();
            stackCount = new ArrayList<>();
            Stack<Integer> s = new Stack<>();
            stacks.add(s);
            stackCount.add(0);
            totalStacks = 1;
            this.threshold = threshold;
        }

        public void push(int value){
            //Check if the final stack is full or not.
            if(stackCount.get(totalStacks-1) == threshold){
                //If the last stack is full then add one more stack in the end of the ArrayList and Increase the totalStack Count
                Stack<Integer> temp = new Stack<>();
                temp.push(value);
                totalStacks++;
                stackCount.add(1);
                stacks.add(temp);
            }
            else{
                //If not just add the element and increase the count of that particular Stack
                stacks.get(totalStacks-1).push(value);
                stackCount.set(totalStacks-1, stackCount.get(totalStacks-1) + 1);
            }
        }

        public int pop(){
            int element;
            //If POP is called when totalStack is 1 and the count for that stack is 0 then POP cannot be performed.
            if(stackCount.get(totalStacks-1) == 0 && totalStacks == 1){
                System.out.println("No Stacks Present");
                return Integer.MAX_VALUE;
            }
            if(stackCount.get(totalStacks-1) == 0){
                //If POP is called when totalStack is greater than 1 but the count for that stack is 0 then POP can be performed
                // but on the previous stack so we reduce the count and delete the empty stack and change the stckCount.
                stackCount.remove(totalStacks-1);
                stacks.remove(totalStacks-1);
                totalStacks--;
                if(totalStacks <= 0){
                    System.out.println("No Stacks Present");
                    return Integer.MAX_VALUE;
                }
                element = stacks.get(totalStacks-1).pop();
                stackCount.set(totalStacks-1, stackCount.get(totalStacks-1) - 1);
            }
            else{
                //Normal Condition just POP the element from the last stack and reduce the count
                element = stacks.get(totalStacks-1).pop();
                stackCount.set(totalStacks-1, stackCount.get(totalStacks-1) - 1);
            }
            return element;
        }

        public int popAt(int stackNo){
            //If the stack to be removed is more than the totalStacks return null
            if(stackNo > totalStacks){
                System.out.println("Stack not Present");
                return Integer.MAX_VALUE;
            }

            // StackNo is the last stack and the count is greater than just make a call to the POP function
            if(stackNo == totalStacks && stackCount.get(totalStacks-1) > 0){
                return pop();
            }

            int element;
            // Else just POP the element from the stack that is required from.
            element = stacks.get(stackNo).pop();
            stackCount.set(stackNo, stackCount.get(stackNo) - 1);
            return element;
        }

    }
}
