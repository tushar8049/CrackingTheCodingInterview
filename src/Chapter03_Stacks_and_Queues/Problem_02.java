package Chapter03_Stacks_and_Queues;

import java.util.Stack;

/**
 * Problem 2: Stack Min
 * How would you design a stack which, in addition to push and pop,
 * has a function min which returns the minimum element?
 * Push, pop and min should all operate in 0(1) time.
 */

public class Problem_02 {
    public static void main(String[] str){

        StackWithMin minStack = new StackWithMin();

        minStack.push(3);
        minStack.push(4);
        minStack.push(2);
        minStack.push(5);
        minStack.push(1);
        minStack.push(6);

        System.out.println(minStack.findMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.findMin());
    }

    /**
     * Time Complexity: PUSH, POP, MIN: O(1)
     * Space Complexity: O(n)
     */
    public static class StackWithMin extends Stack<Integer>{
        private Stack<Integer> minStack;

        public StackWithMin(){
            this.minStack = new Stack<>();
        }

        public void push(int data){
            if( data < findMin() )
                this.minStack.push(data);
            super.push(data);
        }

        public Integer pop(){
            int data = super.pop();
            if(data == findMin())
                this.minStack.pop();
            return data;
        }

        public int findMin(){
            if(this.minStack.isEmpty())
                return Integer.MAX_VALUE;
            else
                return minStack.peek();
        }

    }
}
